package com.learn.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.learn.exception.CIBILNotFoundException;
import com.learn.exception.IndividualNotFoundException;
import com.learn.model.CIBILResponseModel;
import com.learn.model.CIBILScore;
import com.learn.model.Individual;
import com.learn.model.ResponseModel;
import com.learn.model.UniversityResponseModel;
import com.learn.repo.IndividualRepo;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class VerificationResource {

	@Autowired
	IndividualRepo irepo;
	
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@GetMapping("/verify/{id}")
	public ResponseEntity<ResponseModel> getVerificiationEmp(@PathVariable("id") Long empId) throws IndividualNotFoundException
	{
		

		Optional<Individual> emp=irepo.findById(empId);
		Individual indi=emp.isPresent()?emp.get():new Individual();
		CIBILResponseModel cibilresponse=new CIBILResponseModel();
		UniversityResponseModel uresponse=new UniversityResponseModel();
		if(indi.getPan()!=null)
		{
			
			//retrieve returns response body

			cibilresponse=webClientBuilder.build()
								  .get()
								  .uri("http://cibil-service/cibil/"+indi.getPan())
								  .retrieve()
								  .onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus)
										  , clientResponse -> Mono.error(new CIBILNotFoundException("No cibil found")))
								  .bodyToMono(CIBILResponseModel.class)
								  .block();
			
			uresponse=webClientBuilder.build()
					  .get().uri("http://university-service/university/"+indi.getUniversityCode()+"/"+indi.getDegreecertificateNo()+"")
					.retrieve()
					 .onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus)
							  , clientResponse -> Mono.error(new IndividualNotFoundException("Student Not Found with the specifed degree.")))
					  .bodyToMono(UniversityResponseModel.class).block();
		}
		else
		{
			throw new IndividualNotFoundException("Individual not found for the ID"+empId);
		}
		
		return new ResponseEntity<ResponseModel>(new ResponseModel(indi.getName(),
				cibilresponse.getPanverfication()?"Verified":"PAN Not Found",
						uresponse.getGrade()!=null?uresponse.getGrade():"Not Found", 
				cibilresponse.getCibilScores()), HttpStatus.OK);
		
		
		
	}
}

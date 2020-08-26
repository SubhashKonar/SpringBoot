package com.learn.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.learn.model.CIBILScore;
import com.learn.model.NSDLResponseModel;
import com.learn.model.ResponseModel;
import com.learn.repo.CIBILRepo;

@RestController
@RequestMapping("/cibil")
public class CIBILResource {
	
	@Autowired
	CIBILRepo crepo;

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@GetMapping("/{pan}")
	public  ResponseEntity<ResponseModel> getcibilScore(@PathVariable("pan") String pan )
	{
		
		
		/*
		 * List<CIBILScore> cibilScore=Arrays.asList(new CIBILScore(pan,"jull","750"),
		 * new CIBILScore(pan,"jun","750"));
		 */
		List<CIBILScore> cibilScore = crepo.findByPan(pan);
		
		NSDLResponseModel nsdlResponse=webClientBuilder.build()//create("http://nsdl-service")
				  .get().uri(uriBuilder->uriBuilder.host("nsdl-service")
						  							.path("/nsdl")
									  			   .queryParam("pan", pan)
									  			   .build())
				  .retrieve()
				  .bodyToMono(NSDLResponseModel.class)
				  .block();
		ResponseModel response=new ResponseModel(pan,nsdlResponse.getPanVerification(), cibilScore);
		return new ResponseEntity<ResponseModel>(response,HttpStatus.OK) ;
	}

}

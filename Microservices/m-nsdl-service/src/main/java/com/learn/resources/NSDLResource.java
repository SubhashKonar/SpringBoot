package com.learn.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.model.ResponseModel;


@RestController

public class NSDLResource {

	
	@GetMapping("/nsdl")
	public ResponseEntity<ResponseModel> getPanStatus(@RequestParam(name = "pan") String pan)
	{
		ResponseModel response=new ResponseModel();
		response.setPan(pan);
		response.setPanVerification(true);
		return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
	}
	
}

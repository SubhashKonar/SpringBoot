package com.learn;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.model.Example;
import com.learn.repo.PatientRepo;

import net.minidev.json.JSONObject;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

public class Covid19TrackerApplication  {

	@Autowired
	PatientRepo prepo;
	public static void main(String[] args) {
		SpringApplication.run(Covid19TrackerApplication.class, args);
		 
	}
	/*
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * String pinCode="400078"; String
	 * abc=WebClient.create("https://api.postalpincode.in") .get()
	 * .uri("/pincode/"+pinCode+"") .retrieve() .bodyToMono(String.class).block();
	 * // abc=abc.substring(1, abc.length()-1); JSONObject json=new JSONObject();
	 * json.put("abc", abc); System.out.println(json.toJSONString());
	 * 
	 * 
	 * 
	 * }
	 */



}

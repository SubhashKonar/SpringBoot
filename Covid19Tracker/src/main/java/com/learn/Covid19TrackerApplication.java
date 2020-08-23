package com.learn;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.learn.repo.PatientRepo;

import net.minidev.json.JSONObject;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

public class Covid19TrackerApplication  {

	
	public static void main(String[] args) {
		SpringApplication.run(Covid19TrackerApplication.class, args);
		 
	}




}

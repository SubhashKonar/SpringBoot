package com.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import com.learn.model.CIBILScore;
import com.learn.repo.CIBILRepo;

@SpringBootApplication
@EnableEurekaClient
public class MCibilServiceApplication implements ApplicationRunner{

	@Autowired
	CIBILRepo crepo;
	

	@Bean
	@LoadBalanced
	public WebClient.Builder loadBalancedWebClientBuilder() {
		return WebClient.builder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MCibilServiceApplication.class, args);
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * CIBILScore cscore=new CIBILScore(); cscore.setPan("AAAAA1232B");
		 * cscore.setMonth("Feb"); cscore.setScore("700");
		 * 
		 * crepo.save(cscore);
		 */
	}

}

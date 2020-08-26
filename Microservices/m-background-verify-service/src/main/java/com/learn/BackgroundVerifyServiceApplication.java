package com.learn;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class BackgroundVerifyServiceApplication implements ApplicationRunner {

	


	@Bean
	@LoadBalanced
	public WebClient.Builder loadBalancedWebClientBuilder() {
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(BackgroundVerifyServiceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println();
		/*
		 * Individual i=new Individual((long) 1, "name", "9933669988", "asd@sd.com",
		 * "AAAAA1232B", "as", "asd"); repo.save(i);
		 */

	}

}

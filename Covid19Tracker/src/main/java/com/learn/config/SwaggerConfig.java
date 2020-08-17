package com.learn.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	//configuring swagger using Docket.
	
	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.learn.controller"))
				.build()
				.apiInfo(getAPIInfo());
		
	}

	private ApiInfo getAPIInfo() {
		 return new ApiInfo("Covid19 Patient Management REST API",
	                "Documentation for covid19ManagementApp for 3rd party",
	                "1.0",
	                "Free to Use",
	                new Contact("Subhash","https://github.com/SubhashKonar","konarsubhash1994@gmail.com"),
	                null,
	                null,
	                new ArrayList<>()
	        );
	}
	

}

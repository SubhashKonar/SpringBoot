package com.learn.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class APIError {
	
	   private HttpStatus status;
	    private List<String> errors;
	    private LocalDateTime timestamp;
	    private String path;

	    public APIError() {
	        this.timestamp = LocalDateTime.now();
	    }

}

package com.learn.exception;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;

import com.learn.model.APIError;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseStatusExceptionHandler{

	@ExceptionHandler({IndividualNotFoundException.class})
	public ResponseEntity<APIError> handleIndividualNotFound(IndividualNotFoundException ex, ServletWebRequest req)
	   {
		
		
		APIError apiError = new APIError();
		    
		    
		       apiError.setErrors(Arrays.asList(Optional.of(ex.getMessage()).orElse(ex.getClass().getSimpleName())));
		       
		       apiError.setStatus(HttpStatus.NOT_FOUND);
		       apiError.setPath(req.getRequest().getRequestURI());
		  
		    return new ResponseEntity<>(
		               apiError, new HttpHeaders(), apiError.getStatus());
	   }
	@ExceptionHandler({CIBILNotFoundException.class})
	public ResponseEntity<APIError> handleCIBILNotFound(Exception ex, ServletWebRequest req)
	   {
		
		
		APIError apiError = new APIError();
		    
		    
		       apiError.setErrors(Arrays.asList(Optional.of(ex.getMessage()).orElse(ex.getClass().getSimpleName())));
		       
		       apiError.setStatus(HttpStatus.NOT_FOUND);
		       apiError.setPath(req.getRequest().getRequestURI());
		  
		    return new ResponseEntity<>(
		               apiError, new HttpHeaders(), apiError.getStatus());
	   }
}

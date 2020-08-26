package com.learn.exception;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learn.model.APIError;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({StudentNotFoundException.class})
	public  ResponseEntity<APIError> handleStudentNotFoundException(StudentNotFoundException ex,ServletWebRequest req)
	
	{
		APIError apiError=new APIError();
		  
	       apiError.setErrors(Arrays.asList(ex.getMessage()));
	       
	       apiError.setStatus(HttpStatus.NOT_FOUND);
	       apiError.setPath(req.getRequest().getRequestURI());
	  
	    return new ResponseEntity<>(
	               apiError, new HttpHeaders(), apiError.getStatus());
	}
}

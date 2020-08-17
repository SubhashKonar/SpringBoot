package com.learn.exception;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {


protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
	   BindingResult binding= ex.getBindingResult();
	   List<FieldError> fieldErrors=binding.getFieldErrors();
	   List<String> listerrors=fieldErrors
			   					.stream()
			   					.map(err -> err.getField() + ":" + err.getDefaultMessage())
			   					.collect(Collectors.toList());

       ApiError apiError = new ApiError();
       apiError.setErrors(listerrors);
       apiError.setStatus(HttpStatus.BAD_REQUEST);
       apiError.setPath(request.getDescription(false));

	   
	   
	return new ResponseEntity<>(
            apiError, new HttpHeaders(), apiError.getStatus());
}

   @ExceptionHandler({ConstraintViolationException.class})
	protected ResponseEntity<Object> handleConstraintViolation( ConstraintViolationException ex, ServletWebRequest request) {

       Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
       List<String> errors = constraintViolations
               .stream()
               .map(err -> err.getRootBeanClass().getName() + " " + // getRootBeanClass().getName() will give bean class name
                       err.getPropertyPath() + ": " + err.getMessage())
               .collect(Collectors.toList());
       
       ApiError apiError = new ApiError();
       apiError.setErrors(errors);
       
       apiError.setStatus(HttpStatus.BAD_REQUEST);
       apiError.setPath(request.getRequest().getRequestURI());
       return new ResponseEntity<>(
               apiError, new HttpHeaders(), apiError.getStatus());
	}
   
   @ExceptionHandler({DataIntegrityViolationException.class})
   ResponseEntity<Object> handlePersistentException(DataIntegrityViolationException ex, ServletWebRequest request)
   {
	   Throwable cause=ex.getRootCause();
	   ApiError apiError = new ApiError();
	    
	    
	       apiError.setErrors(Arrays.asList(cause.getLocalizedMessage()));
	       
	       apiError.setStatus(HttpStatus.BAD_REQUEST);
	       apiError.setPath(request.getRequest().getRequestURI());
	  
	    return new ResponseEntity<>(
	               apiError, new HttpHeaders(), apiError.getStatus());
	   
   }
   
   @ExceptionHandler(PatientNotFoundException.class)
   ResponseEntity<Object> handlePatientNotFoundException(PatientNotFoundException ex,ServletWebRequest req)
   {
	
	   ApiError apiError = new ApiError();
	    
	    
	       apiError.setErrors(Arrays.asList(ex.getMessage()));
	       
	       apiError.setStatus(HttpStatus.NOT_FOUND);
	       apiError.setPath(req.getRequest().getRequestURI());
	  
	    return new ResponseEntity<>(
	               apiError, new HttpHeaders(), apiError.getStatus());
   }
}

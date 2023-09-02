package com.syntellect.service.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
    public ResponseEntity<ErrorDetails> handleException(ResourceNotFoundException ine,WebRequest request){
		ErrorDetails errorResponse = new ErrorDetails(LocalDateTime.now(),ine.getMessage(),request.getDescription(false),HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ErrorDetails>(errorResponse,HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler
    public ResponseEntity<ErrorDetails> handleException(ResourceErrorException ine, WebRequest request){
		ErrorDetails errorResponse = new ErrorDetails(LocalDateTime.now(),ine.getMessage(),request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<ErrorDetails>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		ErrorDetails errorResponse = new ErrorDetails(LocalDateTime.now(), "Validation Failed",ex.getBindingResult().toString(),HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
	}
}

package com.syntellect.service.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorDetails> handleException(ResourceNotFoundException ine){
		ErrorDetails errorResponse = new ErrorDetails(LocalDateTime.now(),ine.getMessage(),"",HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorDetails>(errorResponse,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorDetails> handleException(ResourceErrorException ine){
		ErrorDetails errorResponse = new ErrorDetails(LocalDateTime.now(),ine.getMessage(),"",HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<ErrorDetails>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorDetails> handleException(Exception ine){
		ErrorDetails errorResponse = new ErrorDetails(LocalDateTime.now(),ine.getMessage(),"",HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ErrorDetails>(errorResponse,HttpStatus.BAD_REQUEST);
	}
}

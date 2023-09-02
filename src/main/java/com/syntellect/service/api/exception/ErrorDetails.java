package com.syntellect.service.api.exception;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ErrorDetails {
	private LocalDateTime timestamp;
    private String message;
    private String details;
    private int status;
    
    ErrorDetails(LocalDateTime timestamp,String message,String details,int status){
    	this.timestamp=timestamp;
    	this.message=message;
    	this.details=details;
    	this.status=status;
    }
    
}

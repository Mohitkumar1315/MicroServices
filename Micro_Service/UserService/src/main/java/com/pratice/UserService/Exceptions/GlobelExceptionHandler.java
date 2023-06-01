package com.pratice.UserService.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pratice.UserService.payload.ApiResponse;


@RestControllerAdvice
public class GlobelExceptionHandler 
{
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFound ex)
	{
		String msg=ex.getMessage();
		//ApiResponse response=ApiResponse.builder()
		return null;		
	}
}

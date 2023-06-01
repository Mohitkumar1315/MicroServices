package com.pratice.UserService.payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter

@AllArgsConstructor
@NoArgsConstructor
@Builder   //it is use to create a instanse of class 
public class ApiResponse 
{
	private String message;
	private boolean success;
	private HttpStatus status;
	public static ApiResponse builder() 
	{
		
		return new ApiResponse();
	}
/*	public void  setMessage(String msg) 
	{
			this.message=msg;
	}
	public void setSucces(Boolean b)
	{
		this.success=b;
	}*/

	
	
}

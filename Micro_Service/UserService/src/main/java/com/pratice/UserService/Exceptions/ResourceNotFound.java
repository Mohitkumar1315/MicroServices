package com.pratice.UserService.Exceptions;

public class ResourceNotFound extends RuntimeException
{
	public ResourceNotFound()
	{
		super("Resource Not found");
	}
	
	public ResourceNotFound(String msg)
	{
		super(msg);
	}
}

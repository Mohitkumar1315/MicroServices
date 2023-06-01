package com.pratice.HotelService.Exception;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String msg)
    {
            super(msg);
    }
    public ResourceNotFound()
    {
        super("Resurce not found!!....");
    }
}

package com.maxi.backservico.services.exceptions;

public class CpfConflictException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CpfConflictException(String message, Throwable cause){
        super(message, cause);
    }

    public CpfConflictException(String message){
        super(message);
    }

    
}

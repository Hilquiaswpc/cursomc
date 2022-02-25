package com.hilquias.services.exceptions;

public class DataIntegrityException extends RuntimeException {

    private  static final long serialVersionUID;

    static {
        serialVersionUID = 1l;
    }

    public DataIntegrityException(String msg){
        super(msg);
    }

    public DataIntegrityException(String msg , Throwable cause){
        
    }
}

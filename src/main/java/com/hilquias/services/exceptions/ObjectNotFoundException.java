package com.hilquias.services.exceptions;

public class ObjectNotFoundException  extends RuntimeException {

    private  static final long serialVersionUID;

    static {
        serialVersionUID = 1l;
    }

    public ObjectNotFoundException(String msg){
        super(msg);
    }

    public  ObjectNotFoundException(String msg , Throwable cause){
        
    }
}

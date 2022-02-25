package com.hilquias.resources.Exception;

import com.hilquias.services.exceptions.DataIntegrityException;
import com.hilquias.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ResouceExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class )
  public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
    StandarError err = new StandarError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
    return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }

  @ExceptionHandler(DataIntegrityException.class )
  public ResponseEntity<StandarError> dataintegrity(DataIntegrityException e, HttpServletRequest request){
    StandarError err = new StandarError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
  }
}

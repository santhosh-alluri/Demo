package com.API.Controller;

import java.net.http.HttpHeaders;
import java.util.Date;

import org.hibernate.persister.walking.spi.WalkingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.API.errors.ResourceNotFoundException;
import com.API.model.ErrorDetails;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllWrongFormatExceptions(ResourceNotFoundException  ex,
            WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails((java.sql.Date) new Date(), ex.getMessage(), request.getDescription(true));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex,
            WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails((java.sql.Date) new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
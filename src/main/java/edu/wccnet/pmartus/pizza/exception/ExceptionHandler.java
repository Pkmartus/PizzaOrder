package edu.wccnet.pmartus.pizza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    //best practice is to remove this to another class and use annotate using
    //@controllerAdvice (and probably remove the logic to a separate method)
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NotFoundException e) {
        return createException(e, HttpStatus.NOT_FOUND.value());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public  ResponseEntity<ErrorResponse> handleException(Exception e) {
        return createException(e, HttpStatus.BAD_REQUEST.value());
    }

    private ResponseEntity<ErrorResponse> createException(Exception e, int status) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage(e.getMessage());
        error.setStatus(status);
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

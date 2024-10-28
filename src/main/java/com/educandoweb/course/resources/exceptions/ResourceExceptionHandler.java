package com.educandoweb.course.resources.exceptions;

import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    //dentro do parenteses vai o nome da exceção que eu irei interceptar
    @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<StandardError> resourceNotFound (ResourceNotFoundException e , HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), request.getRequestURI(), error, e.getMessage(), status.value());
        return ResponseEntity.status(status).body(err);
                //.status para que seja personalizado e aceite o status definido
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database (DatabaseException e , HttpServletRequest request){
        String error = "Database Error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), request.getRequestURI(), error, e.getMessage(), status.value());
        return ResponseEntity.status(status).body(err);
    }
}

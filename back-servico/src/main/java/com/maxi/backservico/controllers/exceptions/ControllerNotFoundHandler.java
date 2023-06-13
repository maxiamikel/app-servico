package com.maxi.backservico.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maxi.backservico.services.exceptions.CpfConflictException;
import com.maxi.backservico.services.exceptions.DataIntegrityViolationException;
import com.maxi.backservico.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ControllerNotFoundHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e) {
        StandardError error = new StandardError(e.getMessage(), System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(CpfConflictException.class)
    public ResponseEntity<StandardError> cpfConflictException(CpfConflictException e) {
        StandardError error = new StandardError(e.getMessage(), System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e) {
        StandardError error = new StandardError(e.getMessage(), System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        ValidationError error = new ValidationError("Erro de validação dos campos",System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
        for(FieldError x : e.getBindingResult().getFieldErrors()){
            error.addErrors(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}

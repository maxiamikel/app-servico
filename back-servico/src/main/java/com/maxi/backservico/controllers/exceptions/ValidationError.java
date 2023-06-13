package com.maxi.backservico.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(String error, Long timestemp, Integer status) {
        super(error, timestemp, status);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String fileName, String message) {
        this.errors.add(new FieldMessage(fileName, message));
    } 
}

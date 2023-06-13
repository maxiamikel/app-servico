package com.maxi.backservico.controllers.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{

    private static final long serialVersionUID =1L;

    private String error;
    private Long timestemp;
    private Integer status;

    public StandardError() {
        super();
    }

    public StandardError(String error, Long timestemp, Integer status) {
        this.error = error;
        this.timestemp = timestemp;
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Long getTimestemp() {
        return timestemp;
    }

    public void setTimestemp(Long timestemp) {
        this.timestemp = timestemp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

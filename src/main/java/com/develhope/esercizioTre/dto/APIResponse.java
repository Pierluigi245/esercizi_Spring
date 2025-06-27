package com.develhope.esercizioTre.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class APIResponse {
    private boolean success ;
    private String message ;
    private Object content ;
    private List <String> errors = new ArrayList<>() ;
    private LocalDateTime currentTime = LocalDateTime.now() ;

    //costruttore default
    public APIResponse() {
        this.success = true ;
    }

    //costruttore per messaggi di errore
    public APIResponse(String message) {
        this.success = false ;
        this.message = message ;
    }

    //costruttore per esito risposta
    public APIResponse(Object content) {
        this.success = true ;
        this.content = content ;
    }

    public APIResponse(String message , Boolean success) {
        this.success = success ;
        this.message = message ;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }
}

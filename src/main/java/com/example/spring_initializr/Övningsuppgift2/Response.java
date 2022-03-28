package com.example.spring_initializr.Övningsuppgift2;

public class Response {
    private String message;
    private Boolean status;

    public Response() {
    }

    public Response(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
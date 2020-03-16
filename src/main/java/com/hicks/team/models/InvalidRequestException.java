package com.hicks.team.models;

public class InvalidRequestException extends RuntimeException {

    private String message = "";

    public InvalidRequestException(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

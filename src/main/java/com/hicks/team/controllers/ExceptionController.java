package com.hicks.team.controllers;

import com.hicks.team.models.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = InvalidRequestException.class)
    public ResponseEntity<Object> exception(InvalidRequestException e) {
        //todo logging here
        return new ResponseEntity<>(new ExceptionObject(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    class ExceptionObject {
        private String message = "";

        public ExceptionObject(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}

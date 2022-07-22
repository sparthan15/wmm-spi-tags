package com.wmm.api.tags.domain.exception;

public class IncompleteResponseDataException extends RuntimeException{

    public IncompleteResponseDataException(String message){
        super(message);
    }
}

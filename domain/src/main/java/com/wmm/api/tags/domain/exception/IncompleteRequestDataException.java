package com.wmm.api.tags.domain.exception;

public class IncompleteRequestDataException extends RuntimeException{

    public IncompleteRequestDataException(String message){
        super(message);
    }
}

package com.wmm.api.tags.domain.exception;

public class TagNotFoundException extends RuntimeException {

    public TagNotFoundException() {
        super("Tag does not exist");
    }
}
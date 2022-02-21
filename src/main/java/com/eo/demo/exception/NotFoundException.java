package com.eo.demo.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Long id) {
        super(String.format("Entity not found with id: %d", id));
    }

}

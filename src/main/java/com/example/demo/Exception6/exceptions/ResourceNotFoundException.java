package com.example.demo.Exception6.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("REsource not found");
    }
}

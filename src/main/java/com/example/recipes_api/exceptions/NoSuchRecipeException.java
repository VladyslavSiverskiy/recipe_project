package com.example.recipes_api.exceptions;

public class NoSuchRecipeException extends RuntimeException{

    public NoSuchRecipeException(String message) {
        super(message);
    }
}

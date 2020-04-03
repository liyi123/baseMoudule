package com.base.exception.advice;

public class Forbidden403Exception extends RuntimeException  {
    public Forbidden403Exception(String message) {
        super(message);
    }
}

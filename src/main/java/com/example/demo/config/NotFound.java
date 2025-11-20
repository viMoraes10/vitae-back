package com.example.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFound extends ResponseStatusException {
    public NotFound(String msg) { super(HttpStatus.NOT_FOUND, msg); }
}

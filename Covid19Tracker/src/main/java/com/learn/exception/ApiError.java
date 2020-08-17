package com.learn.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiError {

    private HttpStatus status;
    private List<String> errors;
    private LocalDateTime timestamp;
    private String path;

    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }


}
package com.adopt.pet.applications.web.dto.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ErrorDefault {
    private LocalDateTime instant = LocalDateTime.now();
    private HttpStatus status;
    private List<String> errors;
    private String causa;

    public ErrorDefault(List<String> errors, HttpStatus status, String causa) {
        this.errors = errors;
        this.causa = causa;
        this.status = status;
    }

}

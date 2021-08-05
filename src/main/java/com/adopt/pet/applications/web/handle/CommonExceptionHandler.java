package com.adopt.pet.applications.web.handle;

import com.adopt.pet.applications.web.dto.exceptions.ApiError;
import com.adopt.pet.applications.web.dto.exceptions.ErrorDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDefault> errorConverter(HttpMessageNotReadableException httpMessageNotReadableException) {
        var errors = new ArrayList<String>();

        errors.add(httpMessageNotReadableException.getMessage());

        var error = new ErrorDefault(errors, HttpStatus.BAD_REQUEST, httpMessageNotReadableException.getCause().toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiError> handleNotFound(ResponseStatusException ex) {
        if (ex.getStatus() == HttpStatus.NOT_FOUND) {
            var response = new ApiError(
                    HttpStatus.NOT_FOUND.name(),
                    ex.getMessage()
            );
            return new ResponseEntity<>(response, null, HttpStatus.NOT_FOUND);
        } else {
            var response = new ApiError(
                    HttpStatus.BAD_REQUEST.name(),
                    ex.getMessage()
            );
            return new ResponseEntity<>(response, null, HttpStatus.BAD_REQUEST);
        }
    }
}

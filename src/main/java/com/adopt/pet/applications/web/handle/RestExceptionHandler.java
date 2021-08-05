package com.adopt.pet.applications.web.handle;


import com.adopt.pet.applications.web.dto.exceptions.ErrorObject;
import com.adopt.pet.applications.web.dto.exceptions.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        var errors = getErrors(ex);
        var errorResponse = getErrorResponse(ex, status, errors);
        return ResponseEntity.status(status.value()).body(errorResponse);

    }

    private ErrorResponse getErrorResponse(
            MethodArgumentNotValidException ex,
            HttpStatus status,
            List<ErrorObject> errors
    )  {
        return ErrorResponse.builder()
                .message("Request has invalid fields")
                .code(status.value())
                .status(status.getReasonPhrase())
                .objectName( ex.getBindingResult().getObjectName())
                .errors(errors)
                .build();
    }

    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map (error -> ErrorObject.builder()
                        .message(error.getDefaultMessage())
                        .field(error.getField())
                        .parameter(error.getRejectedValue())
                        .build())
                .collect(Collectors.toList());
    }
}
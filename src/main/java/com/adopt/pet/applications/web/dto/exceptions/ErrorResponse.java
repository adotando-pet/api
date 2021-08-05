package com.adopt.pet.applications.web.dto.exceptions;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private int code;
    private String status;
    private String objectName;
    private List<ErrorObject> errors;
}

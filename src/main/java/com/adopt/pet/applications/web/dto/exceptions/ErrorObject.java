package com.adopt.pet.applications.web.dto.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorObject {
    private String message;
    private String field;
    private Object parameter;

}
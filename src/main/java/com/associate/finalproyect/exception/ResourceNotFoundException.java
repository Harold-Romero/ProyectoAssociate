package com.associate.finalproyect.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResourceNotFoundException extends Throwable {
    private String message;
}

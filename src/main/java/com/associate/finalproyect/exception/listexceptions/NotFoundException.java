package com.associate.finalproyect.exception.listexceptions;

import lombok.Data;

/**
 * Development by Harol Romero
 * This class implements the NotFoundException error customization
 */
@Data
public class NotFoundException extends RuntimeException {
    private static final String DESCRIPTION = "Not found exception (404)";

    public NotFoundException(String detail) {super(DESCRIPTION + ". " + detail); }
}

package com.associate.finalproyect.exception.listexceptions;

import lombok.Data;

/**
 * Development by Harol Romero
 * This class implements the ForbiddenException error customization
 */
@Data
public class ForbiddenException extends RuntimeException{
    private static final String DESCRIPTION = "Bad request exception (400)";

    public ForbiddenException(String detail) {super(DESCRIPTION + ". " + detail); }
}

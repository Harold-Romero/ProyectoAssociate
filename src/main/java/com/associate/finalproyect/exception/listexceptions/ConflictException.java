package com.associate.finalproyect.exception.listexceptions;

import lombok.Data;

/**
 * Development by Harol Romero
 * This class implements the ConflictException error customization
 */
@Data
public class ConflictException extends RuntimeException{
    private static final String DESCRIPTION = "Conflict exception (409)";

    public ConflictException(String detail) {super(DESCRIPTION + ". " + detail); }
}

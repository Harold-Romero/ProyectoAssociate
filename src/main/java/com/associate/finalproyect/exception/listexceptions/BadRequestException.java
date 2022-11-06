package com.associate.finalproyect.exception.listexceptions;

import lombok.Data;

/**
 * Development by Harol Romero
 * This class implements the BadRequest error customization
 */
@Data
public class BadRequestException extends RuntimeException{
    private static final String DESCRIPTION = "Bad request exception (400)";

    public BadRequestException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}

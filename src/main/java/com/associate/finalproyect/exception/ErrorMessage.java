package com.associate.finalproyect.exception;

import lombok.Getter;
import lombok.ToString;

/**
 * Development by Harol Romero
 * This class implements the way to present the error to the API.
 */
@Getter
@ToString
public class ErrorMessage {
    private final String exception;
    private final String message;

    public ErrorMessage(Exception exception, String message) {
        this.exception = exception.getClass().getSimpleName();
        this.message = message;
    }
}

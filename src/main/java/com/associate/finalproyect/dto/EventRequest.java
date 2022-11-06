package com.associate.finalproyect.dto;

import lombok.Data;

/**
 * Development by Harol Romero
 * This class implements the model to receive data of the event
 */
@Data
public class EventRequest {

    private String eventName;
    private String eventDescription;
}

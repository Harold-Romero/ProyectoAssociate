package com.associate.finalproyect.dto;

import com.associate.finalproyect.entity.Event;
import com.associate.finalproyect.entity.User;
import lombok.Data;

@Data
public class EventAttendanceRequest {

    private Event event;
    private User user;
    private String commentEvent;
    private byte qualification;
}

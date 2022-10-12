package com.associate.finalproyect.service.interfaces;

import com.associate.finalproyect.dto.EventRequest;
import com.associate.finalproyect.entity.Event;

import java.util.List;

public interface EventService {
    Event createEvent(EventRequest request);
    Event updateEvent(EventRequest request, Long id);
    Event getEventById(Long id);
    List<Event> getAllEvents();
}

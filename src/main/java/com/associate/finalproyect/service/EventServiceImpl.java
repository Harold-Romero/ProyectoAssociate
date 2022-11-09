package com.associate.finalproyect.service;

import com.associate.finalproyect.dto.EventRequest;
import com.associate.finalproyect.entity.Event;
import com.associate.finalproyect.exception.listexceptions.NotFoundException;
import com.associate.finalproyect.repository.EventRepository;
import com.associate.finalproyect.service.interfaces.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Development by Harol Romero
 * This class is the implementing for the event service.
 */
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repository; // service that instantiates "eventRepository"
    private final String EVENTNOTFOUND = "El evento buscado no se encuentra registrado";

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    /**
     * Method that create the event registers
     * @param request = data to create
     * @return = this method return a event created or error if not found data
     */
    @Override
    public Event createEvent(EventRequest request) {
        Event event = new Event();
        event.setEventName(request.getEventName());
        event.setEventDescription(request.getEventDescription());
        return repository.save(event);
    }

    @Override
    public Event updateEvent(EventRequest request, Long id) {
        Optional<Event> eventDb = repository.findById(id);

        if (eventDb.isPresent()){
            Event eventUpdate = eventDb.get();
            eventUpdate.setEventName(request.getEventName());
            eventUpdate.setEventDescription(request.getEventDescription());
            return repository.save(eventUpdate);
        }else {
            throw new NotFoundException(EVENTNOTFOUND);
        }
    }

    @Override
    public Event getEventById(Long id) {
        Optional<Event> eventDb = repository.findById(id);

        if (eventDb.isPresent()) {
            return eventDb.get();
        }else {
            throw new NotFoundException(EVENTNOTFOUND) ;
        }
    }

    @Override
    public List<Event> getAllEvents() {
        return repository.findAll();
    }
}
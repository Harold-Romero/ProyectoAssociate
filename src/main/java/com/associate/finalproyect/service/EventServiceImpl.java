package com.associate.finalproyect.service;

import com.associate.finalproyect.dto.EventRequest;
import com.associate.finalproyect.entity.Event;
import com.associate.finalproyect.exception.listexceptions.NotFoundException;
import com.associate.finalproyect.repository.EventRepository;
import com.associate.finalproyect.service.interfaces.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repository;
    private final String EVENTNOTFOUND = "El evento buscado no se encuentra registrado";

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

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
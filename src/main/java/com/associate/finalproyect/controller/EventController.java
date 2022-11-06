package com.associate.finalproyect.controller;

import com.associate.finalproyect.dto.EventRequest;
import com.associate.finalproyect.entity.Event;
import com.associate.finalproyect.service.interfaces.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Development by Harol Romero
 * This class implements the controller to the event
 */
@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEvent(@RequestBody EventRequest request){
        return ResponseEntity.ok().body(eventService.createEvent(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable Long id, @RequestBody EventRequest request){
        return ResponseEntity.ok().body(eventService.updateEvent(request, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id){
        return ResponseEntity.ok().body(eventService.getEventById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents(){
        return ResponseEntity.ok().body(eventService.getAllEvents());
    }
}
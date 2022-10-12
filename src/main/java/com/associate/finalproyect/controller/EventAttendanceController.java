package com.associate.finalproyect.controller;

import com.associate.finalproyect.dto.CommentAndQualify;
import com.associate.finalproyect.dto.EventAttendanceRequest;
import com.associate.finalproyect.service.interfaces.EventAttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event/attendance")
public class EventAttendanceController {

    private final EventAttendanceService eventAttendanceService;

    public EventAttendanceController(EventAttendanceService eventAttendanceService) {
        this.eventAttendanceService = eventAttendanceService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEventAttendance(@RequestBody EventAttendanceRequest request){
        return ResponseEntity.ok().body(eventAttendanceService.createEventAttendance(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEventAttendance(@PathVariable Long id, @RequestBody CommentAndQualify request){
        return ResponseEntity.ok().body(eventAttendanceService.updateEventAttendance(request, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEventAttendanceById(@PathVariable Long id){
        return ResponseEntity.ok().body(eventAttendanceService.getEventAttendanceById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEventsAttendance(){
        return ResponseEntity.ok().body(eventAttendanceService.getAllEventAttendance());
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> getAllEventsAttendanceByEventId(@PathVariable Long id){
        return ResponseEntity.ok().body(eventAttendanceService.getAllEventAttendanceByEventId(id));
    }
}
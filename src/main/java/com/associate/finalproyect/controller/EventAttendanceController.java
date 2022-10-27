package com.associate.finalproyect.controller;

import com.associate.finalproyect.dto.CommentAndQualify;
import com.associate.finalproyect.dto.EventAttendanceRequest;
import com.associate.finalproyect.service.interfaces.EventAttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Development by Harol Romero
 * This class implements the controller to the event attendance
 */

@RestController
@RequestMapping("/event/attendance")
public class EventAttendanceController {

    private final EventAttendanceService eventAttendanceService;// service implementing "eventAttendance"

    /**
     * controller method
     * @param eventAttendanceService  = class constant
     */
    public EventAttendanceController(EventAttendanceService eventAttendanceService) {
        this.eventAttendanceService = eventAttendanceService;
    }

    /**
     * Method that consume the event attendance create service
     * @param request = data to create
     * @return = this method return a attendance created or error if not found data
     */
    @PostMapping("/create")
    public ResponseEntity<?> createEventAttendance(@RequestBody EventAttendanceRequest request){
        return ResponseEntity.ok().body(eventAttendanceService.createEventAttendance(request));
    }

    /**
     * Method that consume the event attendance create service
     * @param id = id registered in database
     * @param request = data uptaded
     * @return = this method return a attendance updated or error if not found the register or data
     */
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
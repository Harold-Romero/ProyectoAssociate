package com.associate.finalproyect.service.interfaces;

import com.associate.finalproyect.dto.CommentAndQualify;
import com.associate.finalproyect.dto.EventAttendanceRequest;
import com.associate.finalproyect.entity.EventAttendance;

import java.util.List;

/**
 * Development by Harol Romero
 * This interface is the methods firm for the event attendance service.
 */
public interface EventAttendanceService {
    EventAttendance createEventAttendance(EventAttendanceRequest request);
    EventAttendance updateEventAttendance(CommentAndQualify request, Long id);
    EventAttendance getEventAttendanceById(Long id);
    List<EventAttendance> getAllEventAttendance();

    List<EventAttendance> getAllEventAttendanceByEventId(Long id);
}

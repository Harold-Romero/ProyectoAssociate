package com.associate.finalproyect.service.interfaces;

import com.associate.finalproyect.dto.CommentAndQualify;
import com.associate.finalproyect.dto.EventAttendanceRequest;
import com.associate.finalproyect.entity.EventAttendance;

import java.util.List;

public interface EventAttendanceService {
    EventAttendance createEventAttendance(EventAttendanceRequest request);
    EventAttendance updateEventAttendance(CommentAndQualify request, Long id);
    EventAttendance getEventAttendanceById(Long id);
    List<EventAttendance> getAllEventAttendance();

    List<EventAttendance> getAllEventAttendanceByEventId(Long id);
}

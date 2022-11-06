package com.associate.finalproyect.service;

import com.associate.finalproyect.dto.CommentAndQualify;
import com.associate.finalproyect.dto.EventAttendanceRequest;
import com.associate.finalproyect.entity.EventAttendance;
import com.associate.finalproyect.exception.listexceptions.ConflictException;
import com.associate.finalproyect.exception.listexceptions.NotFoundException;
import com.associate.finalproyect.repository.EventAttendanceRepository;
import com.associate.finalproyect.service.interfaces.EventAttendanceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Development by Harol Romero
 * This class is the implementing for the event attendance service.
 */
@Service
public class EventAttendanceServiceImpl implements EventAttendanceService {

    private final EventAttendanceRepository repository; // service implementing "eventAttendance"
    private final String EVENTNOTFOUND = "El evento buscado no se encuentra"; // constant for the error EventNotFound
    private final String EVENTNOTFOUNDREGISTER = "El registro al evento buscado no se encuentra"; // constant for the error Record NotFound

    public EventAttendanceServiceImpl(EventAttendanceRepository repository) {
        this.repository = repository;
    }

    /**
     * Method that create the event attendance registers
     * @param request = data to create
     * @return = this method return a attendance created or error if not found data
     */
    @Override
    public EventAttendance createEventAttendance(EventAttendanceRequest request) {
        Optional<List<EventAttendance>> eventAttendanceDb = repository.findByEvent_Id(request.getEvent().getId());

        if (eventAttendanceDb.isPresent()){
            eventAttendanceDb.get().forEach(eventAttendance -> {
                if (Objects.equals(eventAttendance.getUser().getId(), request.getUser().getId())){
                    throw new ConflictException("El usuario que desea registrar en el evento ya se encuentra registrado");
                }
            });
        }

        EventAttendance eventAttendance = new EventAttendance();
        eventAttendance.setEvent(request.getEvent());
        eventAttendance.setUser(request.getUser());
        eventAttendance.setCommentEvent(request.getCommentEvent());
        eventAttendance.setQualification(request.getQualification());

        return repository.save(eventAttendance);
    }

    /**
     * Method that update the event attendance registers
     * @param id = id registered in database
     * @param request = data uptaded
     * @return = this method return a attendance updated or error if not found the register or data
     */
    @Override
    public EventAttendance updateEventAttendance(CommentAndQualify request, Long id) {
        Optional<EventAttendance> eventAttendanceDb = repository.findById(id);

        if (eventAttendanceDb.isPresent()){
            EventAttendance eventAttendanceUpdate = eventAttendanceDb.get();
            eventAttendanceUpdate.setCommentEvent(request.getCommentEvent());
            eventAttendanceUpdate.setQualification(request.getQualification());
            return repository.save(eventAttendanceUpdate);
        }else {
            throw new NotFoundException(EVENTNOTFOUNDREGISTER);
        }
    }

    @Override
    public EventAttendance getEventAttendanceById(Long id) {
        Optional<EventAttendance> eventAttendanceDb = repository.findById(id);

        if (eventAttendanceDb.isPresent()) {
            return eventAttendanceDb.get();
        }else {
            throw new NotFoundException(EVENTNOTFOUNDREGISTER);
        }
    }

    @Override
    public List<EventAttendance> getAllEventAttendance() {
        return repository.findAll();
    }

    @Override
    public List<EventAttendance> getAllEventAttendanceByEventId(Long id) {
        Optional<List<EventAttendance>> eventAttendances = repository.findByEvent_Id(id);

        if (eventAttendances.isPresent()){
            return eventAttendances.get();
        }else {
            throw new NotFoundException(EVENTNOTFOUND);
        }
    }
}

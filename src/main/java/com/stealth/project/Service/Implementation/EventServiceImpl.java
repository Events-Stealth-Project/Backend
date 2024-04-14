package com.stealth.project.Service.Implementation;

import com.stealth.project.Bean.Event;
import com.stealth.project.Bean.UserEvent;
import com.stealth.project.DTO.UserEventAcceptance;
import com.stealth.project.DTO.UserEventAttendance;
import com.stealth.project.Repository.EventRepository;
import com.stealth.project.Repository.UserEventRepository;
import com.stealth.project.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserEventRepository userEventRepository;

    @Override
    public boolean addEvent(Event event) {
        eventRepository.save(event);
        return true;
    }

    @Override
    public List<Event> viewAllEvents(){
        return eventRepository.findAll();
    }

    @Override
    @Transactional
    public boolean markAttendance(UserEventAttendance userEventAttendance) {
        try {
            UserEvent userEvent = userEventRepository.findUserEventById(userEventAttendance.getUserEventId());
            userEvent.setHasAttended(true);

            userEventRepository.save(userEvent);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    @Transactional
    public boolean markAcceptance(UserEventAcceptance userEventAcceptance) {
        try {
            UserEvent userEvent = userEventRepository.findUserEventById(userEventAcceptance.getUserEventId());
            userEvent.setAccepted(true);

            userEventRepository.save(userEvent);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}

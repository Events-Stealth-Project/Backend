package com.stealth.project.Service.Implementation;

import com.stealth.project.Bean.Event;
import com.stealth.project.Repository.EventRepository;
import com.stealth.project.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public boolean addEvent(Event event) {
        eventRepository.save(event);
        return true;
    }

    @Override
    public List<Event> viewAllEvents(){
        return eventRepository.findAll();
    }
}

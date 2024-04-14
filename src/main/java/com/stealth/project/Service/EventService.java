package com.stealth.project.Service;

import com.stealth.project.Bean.Event;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EventService {

    boolean addEvent(Event event);

    List<Event> viewAllEvents();

}

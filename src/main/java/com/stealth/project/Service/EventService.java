package com.stealth.project.Service;

import com.stealth.project.Bean.Event;
import com.stealth.project.DTO.UserEventAcceptance;
import com.stealth.project.DTO.UserEventAttendance;

import java.util.List;

public interface EventService {

    boolean addEvent(Event event);

    List<Event> viewAllEvents();

    boolean markAttendance(UserEventAttendance userEventAttendance);

    boolean markAcceptance(UserEventAcceptance userEventAcceptance);

}

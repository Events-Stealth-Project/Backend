package com.stealth.project.Controller;

import com.stealth.project.Bean.Event;
import com.stealth.project.DTO.UserEventAcceptance;
import com.stealth.project.DTO.UserEventAttendance;
import com.stealth.project.Service.EventService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/eventController")
public class EventController {

    @Resource
    private EventService eventService;

    @PostMapping("/createEvent")
    @PreAuthorize("hasRole('ORG')")
    public boolean createEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    @GetMapping("/viewEvents")
    @PreAuthorize("hasRole('USER')")
    public List<Event> viewAllEvents(){
        return eventService.viewAllEvents();
    }

    @PostMapping("/markAttendance")
    @PreAuthorize("hasRole('ORG')")
    public boolean markAttendance(@RequestBody UserEventAttendance userEventAttendance){
        return eventService.markAttendance(userEventAttendance);
    }
    @PostMapping("/markAcceptance")
    @PreAuthorize("hasRole('ORG')")
    public boolean markAcceptance(@RequestBody UserEventAcceptance userEventAcceptance){
        return eventService.markAcceptance(userEventAcceptance);
    }
}

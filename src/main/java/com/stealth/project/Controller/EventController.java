package com.stealth.project.Controller;

import com.stealth.project.Bean.Event;
import com.stealth.project.Service.EventService;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
}

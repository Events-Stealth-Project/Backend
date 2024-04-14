package com.stealth.project.Controller;

import com.stealth.project.DTO.ApplyToEvent;
import com.stealth.project.Service.EventService;
import com.stealth.project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/userController")
public class UserController {


    @Autowired
    UserService userService;
    @PostMapping("/applyToEvent")
    @PreAuthorize("hasRole('USER')")
    public boolean applyToEvent(@RequestBody ApplyToEvent applyToEvent){
        return userService.applyToEvent(applyToEvent);
    }
}

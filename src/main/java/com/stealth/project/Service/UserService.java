package com.stealth.project.Service;

import com.stealth.project.DTO.ApplyToEvent;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean applyToEvent(ApplyToEvent applyToEvent);

}

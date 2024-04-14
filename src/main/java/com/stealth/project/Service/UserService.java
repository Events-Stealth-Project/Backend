package com.stealth.project.Service;

import com.stealth.project.DTO.ApplyToEvent;
import com.stealth.project.DTO.UpdateProfile;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean applyToEvent(ApplyToEvent applyToEvent);
    boolean updateProfile(UpdateProfile updateProfile);

}

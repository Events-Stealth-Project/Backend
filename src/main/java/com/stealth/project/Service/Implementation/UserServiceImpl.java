package com.stealth.project.Service.Implementation;

import com.stealth.project.Bean.Event;
import com.stealth.project.Bean.User;
import com.stealth.project.Bean.UserEvent;
import com.stealth.project.DTO.ApplyToEvent;
import com.stealth.project.DTO.UpdateProfile;
import com.stealth.project.Repository.EventRepository;
import com.stealth.project.Repository.UserEventRepository;
import com.stealth.project.Repository.UserRepository;
import com.stealth.project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserEventRepository userEventRepository;

    @Override
    @Transactional
    public boolean applyToEvent(ApplyToEvent applyToEvent){
        try {
            Integer userId = applyToEvent.getUserId();
            Integer eventId = applyToEvent.getEventId();

            Event event = eventRepository.findById(eventId);
            User user = userRepository.findById(userId);

            UserEvent userEvent = new UserEvent(user, event, false, false);
            event.getVolunteers().add(userEvent);
            user.getVolunteeredEvents().add(userEvent);

            userEventRepository.save(userEvent);
            eventRepository.save(event);
            userRepository.save(user);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return true;
    }

    @Override
    public boolean updateProfile(UpdateProfile updateProfile){
        try{
            User user = userRepository.findById(updateProfile.getUserId());

            user.setFirstname(updateProfile.getFirstName());
            user.setGivenName(updateProfile.getGivenName());
            user.setLastName(updateProfile.getLastName());
            user.setPhoneNo(updateProfile.getPhoneNumber());
            user.setDietaryPreferences(updateProfile.getDietaryPreferences());
            user.setOrganizer(updateProfile.isOrganizer());
            user.setCertifications(updateProfile.getCertifications());
            user.setUniversityName(updateProfile.getUniversityName());

            userRepository.save(user);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return true;

    }
}

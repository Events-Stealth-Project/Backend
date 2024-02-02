package com.stealth.project;

import com.stealth.project.Bean.Certification;
import com.stealth.project.Bean.Event;
import com.stealth.project.Bean.User;
import com.stealth.project.Bean.UserEvent;
import com.stealth.project.Repository.EventRepository;
import com.stealth.project.Repository.UserEventRepository;
import com.stealth.project.Repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public void run(String... args) throws Exception {

        User newUser1 = new User("user", "pwd", "user@gmail.com");
        User newUser2 = new User("user", "pwd", "user@gmail.com");
        newUser1.getCertifications().add(entityManager.find(Certification.class, 1));

        Event newEvent1 = new Event("event1", "chill out sess");

        HashSet<User> set1 = new HashSet<>();
        set1.add(newUser1);
        set1.add(newUser2);

        newEvent1.setOrganizers(set1);

        newEvent1.getCertificationsRequired().add(entityManager.find(Certification.class, 1));

        newUser1.getOrganizedEvents().add(newEvent1);
        newUser2.getOrganizedEvents().add(newEvent1);

        entityManager.persist(newUser1);
        entityManager.persist(newUser2);

        entityManager.persist(newEvent1);

        Event retrievedEvent = entityManager.find(Event.class, newEvent1.getId());
        User retrievedUser = entityManager.find(User.class, newUser1.getId());
        System.out.println("###############################" + retrievedUser.getOrganizedEvents());
        System.out.println("###############################" + retrievedEvent.getOrganizers());

        UserEvent ue1 = new UserEvent();
        ue1.setEvent(retrievedEvent);
        ue1.setUser(retrievedUser);
        entityManager.persist(ue1);

        UserEvent rue = entityManager.find(UserEvent.class, ue1.getId());

        retrievedUser.getVolunteeredEvents().add(rue);
        retrievedEvent.getVolunteers().add(rue);

        entityManager.persist(retrievedUser);
        entityManager.persist(retrievedEvent);

    }
}

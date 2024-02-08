package com.stealth.project.Repository;

import com.stealth.project.Bean.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Event findById(long id);
}

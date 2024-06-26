package com.stealth.project.Repository;

import com.stealth.project.Bean.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Integer> {

    UserEvent findUserEventById(Integer userEventId);

}

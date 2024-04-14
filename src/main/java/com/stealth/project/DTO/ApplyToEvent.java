package com.stealth.project.DTO;

import com.stealth.project.Bean.User;

public class ApplyToEvent {

    private Integer userId;
    private Integer eventId;

    public ApplyToEvent(Integer userId, Integer eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
}

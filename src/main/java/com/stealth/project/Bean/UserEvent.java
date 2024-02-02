package com.stealth.project.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "user_event")
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "is_accepted", columnDefinition = "boolean default false")
    private boolean isAccepted;

    @Column(name = "has_attended", columnDefinition = "boolean default false")
    private boolean hasAttended;

    public UserEvent(Long id, User user, Event event, boolean isAccepted, boolean hasAttended) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.isAccepted = isAccepted;
        this.hasAttended = hasAttended;
    }

    public UserEvent() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public boolean isHasAttended() {
        return hasAttended;
    }

    public void setHasAttended(boolean hasAttended) {
        this.hasAttended = hasAttended;
    }

    // constructors, getters, and setters
}

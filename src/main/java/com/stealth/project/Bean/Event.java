package com.stealth.project.Bean;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "EventName")
    private String eventName;
    @Column(name = "EventDescription")
    private String eventDescription;

    @Column(name = "OrganisingClub")
    private String organizingClub;

    @Column(name = "Location")
    private String location;

    @Column(name = "Notes")
    private String notes;

    @Column(name = "VolunteerPoints")
    private String volunteerPoints;

    @Column(name = "NumberOfVolunteers")
    private int numberOfVolunteers;

    @Column(name = "EventDate")
    private Date eventDate;

    @Column(name = "EventStartTime")
    private Time eventStartTime;

    @Column(name = "EventEndTime")
    private Time eventEndTime;

    @OneToMany
    @Column(name="CertficationRequired")
    private Set<Certification> certificationsRequired = new HashSet<>();
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<UserEvent> volunteers = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_event_organizer",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id")
            }
    )
    private Set<User> organizers = new HashSet<>();

    public Event(){

    }
    public Event(String eventName, String eventDescription) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Set<User> getOrganizers() {
        return organizers;
    }

    public void setOrganizers(Set<User> organizers) {
        this.organizers = organizers;
    }

    public String getOrganizingClub() {
        return organizingClub;
    }

    public void setOrganizingClub(String organizingClub) {
        this.organizingClub = organizingClub;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getVolunteerPoints() {
        return volunteerPoints;
    }

    public void setVolunteerPoints(String volunteerPoints) {
        this.volunteerPoints = volunteerPoints;
    }

    public int getNumberOfVolunteers() {
        return numberOfVolunteers;
    }

    public void setNumberOfVolunteers(int numberOfVolunteers) {
        this.numberOfVolunteers = numberOfVolunteers;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Time getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(Time eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public Time getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(Time eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public Set<UserEvent> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(Set<UserEvent> volunteers) {
        this.volunteers = volunteers;
    }

    public Set<Certification> getCertificationsRequired() {
        return certificationsRequired;
    }

    public void setCertificationsRequired(Set<Certification> certificationsRequired) {
        this.certificationsRequired = certificationsRequired;
    }

    public Event(Integer id, String eventName, String eventDescription, String organizingClub, String location, String notes, String volunteerPoints, int numberOfVolunteers, Date eventDate, Time eventStartTime, Time eventEndTime, Set<Certification> certificationsRequired, Set<UserEvent> volunteers, Set<User> organizers) {
        this.id = id;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.organizingClub = organizingClub;
        this.location = location;
        this.notes = notes;
        this.volunteerPoints = volunteerPoints;
        this.numberOfVolunteers = numberOfVolunteers;
        this.eventDate = eventDate;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.certificationsRequired = certificationsRequired;
        this.volunteers = volunteers;
        this.organizers = organizers;
    }

    public Event(Integer id, String eventName, String eventDescription, String organizingClub, String location) {
        this.id = id;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.organizingClub = organizingClub;
        this.location = location;
    }
}
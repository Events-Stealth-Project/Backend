package com.stealth.project.Bean;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Username")
    private String username;

    @Column(name="Password")
    private String password;

    @Column(name="FirstName")
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="GivenName")
    private String givenName;

    @Column(name="PhoneNumber")
    private String phoneNumber;

    @Column(name="Email")
    private String email;

    @OneToMany
    @Column(name="DietaryPreference")
    private Set<DietType> dietaryPreferences = new HashSet<>();

    @OneToMany
    @Column(name="Certfication")
    private Set<Certification> certifications = new HashSet<>();

    @Column(name="isOrganizer")
    private boolean isOrganizer;

    @Column(name="University")
    private String universityName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserEvent> volunteeredEvents = new HashSet<>();

    @ManyToMany(mappedBy = "organizers", cascade = CascadeType.ALL)
    private Set<Event> organizedEvents = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(){
    }

    public User(String username,String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isOrganizer() {
        return isOrganizer;
    }

    public void setOrganizer(boolean organizer) {
        isOrganizer = organizer;
    }

    public Set<Event> getOrganizedEvents() {
        return organizedEvents;
    }

    public void setOrganizedEvents(Set<Event> organizedEvents) {
        this.organizedEvents = organizedEvents;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getGivenname() {
        return givenName;
    }

    public void setGivename(String givenname) {
        this.givenName = givenname;
    }

    public String getPhoneNo() {
        return phoneNumber;
    }

    public void setPhoneNo(String phoneno) {
        this.phoneNumber = phoneno;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDietaryPreferences(Set<DietType> dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }

    public void setCertifications(Set<Certification> certifications) {
        this.certifications = certifications;
    }

    public Set<DietType> getDietaryPreferences() {
        return dietaryPreferences;
    }

    public Set<Certification> getCertifications() {
        return certifications;
    }

    public Set<UserEvent> getVolunteeredEvents() {
        return volunteeredEvents;
    }

    public void setVolunteeredEvents(Set<UserEvent> volunteeredEvents) {
        this.volunteeredEvents = volunteeredEvents;
    }
}

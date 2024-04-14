package com.stealth.project.DTO;

import com.stealth.project.Bean.Certification;
import com.stealth.project.Bean.DietType;

import java.util.HashSet;
import java.util.Set;

public class UpdateProfile {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String givenName;
    private String phoneNumber;
    private Set<DietType> dietaryPreferences = new HashSet<>();
    private Set<Certification> certifications = new HashSet<>();
    private boolean isOrganizer;
    private String universityName;

    public UpdateProfile(Integer userId, String firstName, String lastName, String givenName, String phoneNumber, Set<DietType> dietaryPreferences, Set<Certification> certifications, boolean isOrganizer, String universityName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.givenName = givenName;
        this.phoneNumber = phoneNumber;
        this.dietaryPreferences = dietaryPreferences;
        this.certifications = certifications;
        this.isOrganizer = isOrganizer;
        this.universityName = universityName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Set<DietType> getDietaryPreferences() {
        return dietaryPreferences;
    }

    public void setDietaryPreferences(Set<DietType> dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }

    public Set<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(Set<Certification> certifications) {
        this.certifications = certifications;
    }

    public boolean isOrganizer() {
        return isOrganizer;
    }

    public void setOrganizer(boolean organizer) {
        isOrganizer = organizer;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}

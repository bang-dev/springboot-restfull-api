package com.dev.dtos;

import com.dev.models.Personal;

import java.util.Date;

public class PersonalDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String major;

    public PersonalDTO(String id, String firstName, String lastName, String major) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
    }

    public PersonalDTO(Personal personal) {
        this.id = personal.getId();
        this.firstName = personal.getFirstName();
        this.lastName = personal.getLastName();
        this.major = personal.getMajor();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}

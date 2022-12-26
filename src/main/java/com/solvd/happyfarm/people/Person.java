package com.solvd.happyfarm.people;

import java.time.LocalDateTime;

public abstract class Person {

    private String name;
    private String lastName;
    private LocalDateTime dob;

    public Person(String name, String lastName, LocalDateTime dob) {
        this.name = name;
        this.lastName = lastName;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }
}

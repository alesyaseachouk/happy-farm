package com.solvd.happyfarm.people;

import java.time.LocalDateTime;

public class Manager extends com.solvd.happyfarm.people.Person {

    public Manager(String name, String lastName, LocalDateTime dob) {
        super(name, lastName, dob);
    }

    @Override
    public String toString() {
        return "Manager{}";
    }
}

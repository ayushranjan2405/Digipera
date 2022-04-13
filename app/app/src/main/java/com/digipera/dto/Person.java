package com.digipera.dto;

public class Person {

    private final String username;
    private final String firstname;
    private final String lastname;
    private final String relation;

    public Person(String username, String firstname, String lastname, String relation) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.relation = relation;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getRelation() {
        return relation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", relation='" + relation + '\'' +
                '}';
    }


}

package org.example;


public class Address {
    int id;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;

    // Constructor
    public Address(int id, String firstName, String lastName, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return + id + ", \"" + firstName + "\", \"" + lastName + "\", " + phoneNumber + ", \"" + email +  "\"";
    }
}

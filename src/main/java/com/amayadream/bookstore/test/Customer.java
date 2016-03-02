package com.amayadream.bookstore.test;

import org.springframework.data.annotation.Id;

/**
 * @author :  Amayadream
 * @date :  2016.03.01 19:42
 */
public class Customer {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
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
}

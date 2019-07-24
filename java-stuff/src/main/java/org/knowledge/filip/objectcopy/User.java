package org.knowledge.filip.objectcopy;

import java.io.Serializable;

public class User implements Cloneable, Serializable {

    private String firstName;
    private String lastName;
    private Address address;

    public User() {
    }

    public User(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public User(User whoToCopy) {
        this(whoToCopy.firstName, whoToCopy.lastName, new Address(whoToCopy.address));
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public Object clone() {
        User user;
        try {
            user = (User) super.clone();
        } catch (CloneNotSupportedException e) {
            user = new User(this.getFirstName(), this.getLastName(), this.getAddress());
        }

        user.address = (Address) this.address.clone();
        return user;
    }
}

package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.User;

import java.util.Objects;

/**
 * This is a basic implementation of a {@link User}.
 * 
 * This class is completely mplemented and can be used as it is.
 * 
 */
public class UserImpl implements User {

    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String username;
    private int hash;

    public UserImpl(final String name, final String surname, final String user) {
        this(name, surname, user, -1);
    }

    public UserImpl(final String name, final String surname, final String user, final int userAge) {
        this.firstName = Objects.requireNonNull(name);
        this.lastName = Objects.requireNonNull(surname);
        this.age = userAge;
        this.username = Objects.requireNonNull(user);
    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }


    public String getUsername() {
        return this.username;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isAgeDefined() {
        return this.age > 0;
    }

    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass().equals(o.getClass())) {
            final UserImpl user = (UserImpl) o;
            return firstName.equals(user.getFirstName())
                && lastName.equals(user.getLastName())
                && username.equals(user.getUsername())
                && age == user.getAge();
        }
        return false;
    }

    public final int hashCode() {
        if (hash == 0) {
            hash = Objects.hash(firstName, lastName, username,  age);
        }
        return hash;
    }

    public String toString() {
        return "[ " + this.firstName + " " + this.lastName + " " + this.age + " " + this.username + " ]";
    }

}

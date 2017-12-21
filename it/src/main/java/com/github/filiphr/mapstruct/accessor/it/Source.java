package com.github.filiphr.mapstruct.accessor.it;

public class Source {

    private String firstName;
    private String lastName;
    private boolean active;
    private boolean admin;

    public Source(String firstName, String lastName, boolean active, boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.admin = admin;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}

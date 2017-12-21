package com.github.filiphr.mapstruct.accessor.it;

public class Target {

    private final String firstName;
    private final String lastName;
    private final boolean active;
    private final boolean admin;

    private Target(String firstName, String lastName, boolean active, boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.admin = admin;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isAdmin() {
        return admin;
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private boolean active;
        private boolean admin;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public Builder isAdmin(boolean admin) {
            this.admin = admin;
            return this;
        }

        public Target build() {
            return new Target( firstName, lastName, active, admin );
        }

    }
}

/*
 *  Copyright 2017-2017 Filip Hrisafov (https://github.com/filiphr)
 *  and/or other contributors as indicated by the @authors tag.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
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

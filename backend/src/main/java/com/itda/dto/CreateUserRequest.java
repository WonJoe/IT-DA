package com.itda.dto;

import com.itda.location.Location;
import com.itda.users.Users;

public class CreateUserRequest {
    private Users users;
    private Location location;

    public CreateUserRequest() {
    }

    public CreateUserRequest(Users users, Location location) {
        this.users = users;
        this.location = location;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}

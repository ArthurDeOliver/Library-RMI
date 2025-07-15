package com.sd.project.common.models;

import java.io.Serializable;

public class User implements Serializable {
    private int userId;
    private String name;
    private String email;

    public User(String name, String email) {
        this.userId = 0;
        this.name = name;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nome: " + name + " | " + email;
    }
}
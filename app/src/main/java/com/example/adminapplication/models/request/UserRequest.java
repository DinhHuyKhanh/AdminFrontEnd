package com.example.adminapplication.models.request;

public class UserRequest {
    private String email;
    private String password;

    public UserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

package com.fmelgoza.secureticketapi.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    public LoginRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {   // 👈 THIS is what’s missing
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
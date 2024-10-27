package com.example.attendance.model;

public class AuthResponse {
    private String token;

    // Constructor that initializes the token when an AuthResponse object is created
    public AuthResponse(String token) {
        this.token = token;  
    }

    public String getToken() {
        return token;  
    }
}

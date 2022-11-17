package com.springbootrestapi.models.auth;

import lombok.Data;

@Data
public class AuthResponse {
    private int id;
    private String username;
    private String email;
    private String accessToken;

    public AuthResponse(){}

    public AuthResponse(int id, String username, String email, String accessToken) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.accessToken = accessToken;
    }
}

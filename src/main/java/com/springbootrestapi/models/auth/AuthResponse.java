package com.springbootrestapi.models.auth;

import com.springbootrestapi.models.User;
import lombok.Data;

@Data
public class AuthResponse {
    private User user;
    private String accessToken;

    public AuthResponse(){}

    public AuthResponse(User user, String accessToken) {
        this.user = user;
        this.accessToken = accessToken;
    }
}

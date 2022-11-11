package com.springbootrestapi.models.auth;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
public class AuthRequest {
    @NotNull @Email @Length(min=5, max=50)
    private String email;
    @NotNull @Length(min=5, max=20)
    private String password;
}

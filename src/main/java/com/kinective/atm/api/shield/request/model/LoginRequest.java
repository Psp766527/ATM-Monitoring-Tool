package com.kinective.atm.api.shield.request.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}

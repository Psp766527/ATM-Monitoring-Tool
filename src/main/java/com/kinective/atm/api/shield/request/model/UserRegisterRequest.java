package com.kinective.atm.api.shield.request.model;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String username;
    private String password;
    private String[] role;
}

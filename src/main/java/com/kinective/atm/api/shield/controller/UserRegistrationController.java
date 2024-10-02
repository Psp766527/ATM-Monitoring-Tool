package com.kinective.atm.api.shield.controller;

import com.kinective.atm.api.shield.request.model.UserRegisterRequest;
import com.kinective.atm.api.shield.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @Operation(summary = "register user api is used for create user in the user base.",
            description = "register user api is used for create user in the user base.")
    @ApiResponse(responseCode = "201", description = "Returns the success if user created successfully")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterRequest registerRequest) {
        String response = userService.registerUser(registerRequest);
        return ResponseEntity.ok(response);
    }
}

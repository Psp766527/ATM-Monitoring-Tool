package com.kinective.atm.api.shield.service;

import com.kinective.atm.api.shield.models.User;
import com.kinective.atm.api.shield.request.model.UserRegisterRequest;
import com.kinective.atm.infrastructure.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String registerUser(UserRegisterRequest userRequest) {

        Optional<User> existingUser = userRepository.findByUsername(userRequest.getUsername());
        if (existingUser.isPresent()) {
            return "Username is already taken!";
        }


        User newUser = new User(userRequest.getUsername(), passwordEncoder.encode(userRequest.getPassword()), userRequest.getRole());
        userRepository.save(newUser);
        return "User registered successfully!";
    }

}

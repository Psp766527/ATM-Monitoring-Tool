package com.kinective.atm.api.shield.models;


import com.kinective.atm.commons.Constants;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = Constants.userCollection)
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private String[] role;

    public User(String username, String password, String[] role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}

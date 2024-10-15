package com.adrive.ADrive.service;

import com.adrive.ADrive.model.Users;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public String login(Users users);
    public ResponseEntity<Users> createUsers(Users users);
}

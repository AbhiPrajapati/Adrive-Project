package com.adrive.ADrive.service;

import com.adrive.ADrive.model.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MyUserDetailService extends UserDetailsService {
    public ResponseEntity<Users> createUsers(Users users);
}

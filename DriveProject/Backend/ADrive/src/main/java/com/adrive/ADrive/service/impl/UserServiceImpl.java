package com.adrive.ADrive.service.impl;

import com.adrive.ADrive.model.Users;
import com.adrive.ADrive.repository.UserRepository;
import com.adrive.ADrive.service.JWTService;
import com.adrive.ADrive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Override
    public String login(Users users) {
        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(),users.getPassword()));
        return authentication.isAuthenticated() ? jwtService.generateToken(users.getUsername()) : "Fail";
    }

    @Override
    public ResponseEntity<Users> createUsers(Users users)
    {
        String encodedPassword = encoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        userRepository.save(users);
        return  ResponseEntity.ok(users);
    }
}

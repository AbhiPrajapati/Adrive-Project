package com.adrive.ADrive.service.impl;

import com.adrive.ADrive.model.MyUserDetails;
import com.adrive.ADrive.model.Users;
import com.adrive.ADrive.repository.UserRepository;
import com.adrive.ADrive.service.JWTService;
import com.adrive.ADrive.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailServiceImpl implements MyUserDetailService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if(user != null){
            return new MyUserDetails(user);
        }else{
            throw new UsernameNotFoundException("User Name Not Found ..");
        }
    }


}

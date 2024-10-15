package com.adrive.ADrive.controller;

import com.adrive.ADrive.model.Users;
import com.adrive.ADrive.service.MyUserDetailService;
import com.adrive.ADrive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;

     @PostMapping("/register")
     public ResponseEntity<Users> register(@RequestBody Users users)
     {
         return userService.createUsers(users);
     }

     @GetMapping("/login")
     public String login(@RequestBody Users users)
     {
         return userService.login(users);
     }



}

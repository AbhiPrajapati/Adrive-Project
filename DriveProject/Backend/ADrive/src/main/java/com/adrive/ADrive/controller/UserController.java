package com.adrive.ADrive.controller;

import com.adrive.ADrive.model.Users;
import com.adrive.ADrive.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private MyUserDetailService myUserDetailService;

     @PostMapping()
     public ResponseEntity<Users> createUsers(@RequestBody Users users)
     {
         return myUserDetailService.createUsers(users);
     }

}

package com.adrive.ADrive.service;


import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
   public String generateToken(String username);
   String extractUserName(String token);
   boolean validateToken(String token, UserDetails userDetails);
}

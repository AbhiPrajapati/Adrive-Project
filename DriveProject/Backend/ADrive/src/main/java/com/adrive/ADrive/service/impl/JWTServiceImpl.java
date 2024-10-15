package com.adrive.ADrive.service.impl;

import com.adrive.ADrive.service.JWTService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class JWTServiceImpl implements JWTService {



    public String key = "";

    public JWTServiceImpl()
    {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGenerator.generateKey();
            key = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public Key getKey()
    {
        return Keys.hmacShaKeyFor(key.getBytes());
    }

    @Override
    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();

        return Jwts.
                builder().
                claims().add(claims).
                subject(username).
                issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 *60 * 30 ))
                .and()
                .signWith(getKey())
                .compact();
    }
}

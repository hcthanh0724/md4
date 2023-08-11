package com.example.demojwt.service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class JwtService {
    //key mã hóa token
    private static final String SECRET_KEY = "13831msggw";
    //thời gian token sống
    private static final long EXPIRE_TIME = 24070000000L;

    //tạo token
    public String createToken(Authentication authentication){
        //lấy đối tượng đăng nhập
        User user = (User) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date().getTime() +EXPIRE_TIME)))
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .compact();
    }
    //lấy username từ token
    public String getUsernameFromJwtToken(String token){
        String userName = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody().getSubject();
        return userName;
    }
}

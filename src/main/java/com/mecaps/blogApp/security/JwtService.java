package com.mecaps.blogApp.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {


//    private static final String SECRET_KEY = "0123456789012345678901234567890123";

    @Value("${jwt.secret-key}")
    private String SECRET_KEY;

    public SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }




    public String accessToken(String email, String role){
        return Jwts.builder()
                .subject(email)
                .claim("Role", role)
                .claim("accessToken", String.class)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()  + 1000 * 60 * 60))
                .signWith(getSecretKey())
                .compact();

    }

    public String refreshToken(String email, String role){
        return Jwts.builder()
                .subject(email)
                .claim("Role", role)
                .claim("refreshToken", String.class)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60
                        * 60 * 24 * 7))
                .signWith(getSecretKey())
                .compact();
    }


//    // utils method for creating a token.
//
//        private String buildToken(String email, String role,
//                              String tokenType, long exp){
//            return Jwts.builder()
//                    .subject(email)
//                    .claim("role", role)
//                    .claim(tokenType, String.class)
//                    .issuedAt(new Date(System.currentTimeMillis()))
//                    .expiration(new Date(System.currentTimeMillis() + exp))
//                    .signWith(getSecretKey())
//                    .compact();
//    }

    public String getEmail(String token){
        return extractAllClaims(token).getSubject();
    }

    public String getRole(String token){
        return extractAllClaims(token).get("Role", String.class);
    }

    public String getTokenType(String token){
        return extractAllClaims(token).get("accessToken", String.class);
    }

    public boolean getExp(String token){
        Claims claims = extractAllClaims(token);
        return claims.getExpiration().after(new Date());
    }
    // utitls methods
    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }



}

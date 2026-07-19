package com.apimonitor.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractEmail(String token) {

        return extractClaim(token, Claims::getSubject);

    }

    public Date extractExpiration(String token) {

        return extractClaim(token, Claims::getExpiration);

    }

    public boolean isTokenValid(String token,
                                org.springframework.security.core.userdetails.UserDetails userDetails) {

        return extractEmail(token).equals(userDetails.getUsername())
                && extractExpiration(token).after(new Date());

    }

    private Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

    private <T> T extractClaim(String token,
                               Function<Claims, T> resolver) {

        return resolver.apply(extractAllClaims(token));

    }

}
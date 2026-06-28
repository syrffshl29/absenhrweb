package com.miniproject.absenhrweb.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtil {

    private static final String SECRET =
            "absenhr-secret-key-2026-super-safe-12345";

    private static Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public static String extractRole(String token) {

        Claims claims =
                Jwts.parserBuilder()
                        .setSigningKey(getSigningKey())
                        .build()
                        .parseClaimsJws(token)
                        .getBody();

        return claims.get("role").toString();
    }

}
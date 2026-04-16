package com.fmelgoza.secureticketapi.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fmelgoza.secureticketapi.model.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET = "my-super-secret-key-change-this";
    private static final long EXPIRATION_MILLIS = 1000L * 60 * 60;

    public String generateToken(User user) {
        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("role", user.getRole().name())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_MILLIS))
                .sign(Algorithm.HMAC256(SECRET));
    }

    public String extractUsername(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token)
                .getSubject();
    }

    public String extractRole(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token)
                .getClaim("role")
                .asString();
    }

    public boolean isTokenValid(String token) {
        try {
            Instant expiresAt = JWT.require(Algorithm.HMAC256(SECRET))
                    .build()
                    .verify(token)
                    .getExpiresAt()
                    .toInstant();
            return expiresAt.isAfter(Instant.now());
        } catch (Exception e) {
            return false;
        }
    }
}
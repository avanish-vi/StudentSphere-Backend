package com.studentsphere.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    /*
     * JWT secret.
     *
     * We give a default value so the application can
     * run even if jwt.secret is not present in
     * application.properties.
     */
    @Value("${jwt.secret:StudentSphereSecretKeyForJWTAuthentication2026VerySecure}")
    private String secret;


    /*
     * Token validity:
     *
     * 24 hours
     */
    private static final long EXPIRATION_TIME =
            24 * 60 * 60 * 1000L;


    /*
     * Create signing key.
     */
    private SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                secret.getBytes(
                        StandardCharsets.UTF_8
                )
        );
    }


    /*
     * Generate JWT token.
     *
     * The user's email is stored as the subject.
     */
    public String generateToken(
            String email
    ) {

        Date now = new Date();

        Date expiration =
                new Date(
                        now.getTime()
                                + EXPIRATION_TIME
                );

        return Jwts.builder()
                .subject(email)
                .issuedAt(now)
                .expiration(expiration)
                .signWith(getSigningKey())
                .compact();
    }


    /*
     * Extract email from JWT.
     */
    public String getEmailFromToken(
            String token
    ) {

        Claims claims =
                Jwts.parser()
                        .verifyWith(getSigningKey())
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();

        return claims.getSubject();
    }


    /*
     * Validate token.
     */
    public boolean isTokenValid(
            String token
    ) {

        try {

            Claims claims =
                    Jwts.parser()
                            .verifyWith(getSigningKey())
                            .build()
                            .parseSignedClaims(token)
                            .getPayload();

            return claims.getExpiration()
                    .after(new Date());

        } catch (Exception exception) {

            return false;
        }
    }
}
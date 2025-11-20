package com.example.demo.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.*;

/**
 * Service class for handling token related operations.
 */
@Service
public class TokenService {

    private static final String ISSUER = "auth-api";

    private final String secret;

    // TTL configurável (padrão: 4h = 14400s)
    private final long ttlSeconds;

    public TokenService(
            @Value("${api.security.token.secret}") String secret,
            @Value("${api.security.token.ttl-seconds:14400}") long ttlSeconds
    ) {
        this.secret = secret;
        this.ttlSeconds = ttlSeconds;
    }

    /**
     * Gera um JWT para o usuário (subject = email).
     */
    public String generateToken(User user) {
        return generateToken(user.getEmail());
    }

    /**
     * Gera um JWT para o subject informado (email).
     */
    public String generateToken(String subjectEmail) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Instant now = Instant.now();
            Instant exp = now.plusSeconds(ttlSeconds);

            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(subjectEmail)
                    .withIssuedAt(now)
                    .withExpiresAt(exp)
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating token", e);
        }
    }

    /**
     * Valida o token e retorna o subject (email) se OK.
     */
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Error while validating token", e);
        }
    }
}
package com.example.demo.infra.security;

import com.example.demo.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {


    private final TokenService tokenService;          // teu service com Auth0
    private final UserDetailsService userDetailsService; // carrega usuário pelo email

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        String token = null;

        if (header != null && header.startsWith("Bearer ")) {
            token = header.substring(7).trim();
        }

        try {
            if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                // subject do token = email
                String email = tokenService.validateToken(token);
                if (email != null && !email.isBlank()) {
                    UserDetails ud = userDetailsService.loadUserByUsername(email);

                    // autentica a requisição atual
                    var auth = new UsernamePasswordAuthenticationToken(
                            ud, null, ud.getAuthorities()
                    );
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        } catch (RuntimeException ex) {
            // token inválido/expirado/assinado com outra chave → responder 401
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\":\"invalid_or_expired_token\"}");
            return; // interrompe a cadeia
        }

        chain.doFilter(request, response);
    }
}

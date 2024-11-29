package com.example.demo.controller;

import com.example.demo.infra.security.TokenService;
import com.example.demo.dto.AuthenticationDTO;
import com.example.demo.dto.LoginResponseDTO;
import com.example.demo.dto.RegisterDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling authentication related requests.
 */
@RestController
@RequestMapping(value ="auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    /**
     * Endpoint for user login.
     *
     * @param data The authentication data transfer object containing the user's email and password.
     * @return A ResponseEntity containing the login response with the JWT token or an error message.
     */
    @PostMapping("/login")
    public ResponseEntity login (@RequestBody @Valid AuthenticationDTO data ){
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    /**
     * Endpoint for user registration.
     *
     * @param registerDTO The registration data transfer object containing the user's details.
     * @return A ResponseEntity indicating the success or failure of the registration.
     */
    @PostMapping("/register")
    public ResponseEntity register (@RequestBody @Valid RegisterDTO registerDTO ){
        try {
            if(this.userRepository.findByEmail(registerDTO.email()) != null) return ResponseEntity.badRequest().build();

            String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
            User newUser = new User(registerDTO.username(), encryptedPassword, registerDTO.role(), registerDTO.email());

            this.userRepository.save(newUser);

            return ResponseEntity.ok().build();

        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }
}
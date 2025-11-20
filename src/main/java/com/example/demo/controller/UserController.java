package com.example.demo.controller;

import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling user related requests.
 */
@RestController
@RequestMapping(value = "/api/users")
@Tag(name = "Users")
public class UserController {

    /**
     * Service class for handling user related operations.
     */
    @Autowired
    private UserService jobService;

    /**
     * Endpoint to get all jobs for a specific user.
     *
     * @param email The email of the user.
     * @return A ResponseEntity containing all jobs for the user or an error message.
     */
    @Operation(summary = "Lista todos os usuários")
    @GetMapping()
    public ResponseEntity<?> getAllUsers (){
        try{
            return ResponseEntity.ok(jobService.getAllUsers());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    @Operation(summary = "Busca usuário pelo email")
    @GetMapping("/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        try{
            return jobService.getUser(email);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

}
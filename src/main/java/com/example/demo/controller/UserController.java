package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling user related requests.
 */
@RestController
@RequestMapping(value = "user")
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
    @GetMapping()
    public ResponseEntity<?> getAllJobs (@RequestParam String email){
        try{
            return jobService.getUser(email);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    @GetMapping("/test")
    public ResponseEntity test(){
        return ResponseEntity.ok("Test");
    }

}
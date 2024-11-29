package com.example.demo.controller;

import com.example.demo.dto.ApplicationDTO;
import com.example.demo.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling application related requests.
 */
@RestController
@RequestMapping(value ="application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    /**
     * Endpoint to get all applications for a specific user.
     *
     * @param userId The ID of the user.
     * @return A ResponseEntity containing all applications for the user or an error message.
     */
    @GetMapping(value = "/{userId}/all")
    public ResponseEntity<?> getAllWithUserId(@PathVariable Long userId){
        try{
            return ResponseEntity.ok(applicationService.getAllWithUserId(userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    /**
     * Endpoint to get all applications for a specific job.
     *
     * @param jobId The ID of the job.
     * @return A ResponseEntity containing all applications for the job or an error message.
     */
    @GetMapping(value = "/{jobId}/all")
    public ResponseEntity<?> getAllWithJobId(@PathVariable Long jobId){
        try{
            return applicationService.getAllWithJobId(jobId);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    /**
     * Endpoint to get all applications.
     *
     * @return A ResponseEntity containing all applications or an error message.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(){
        try{
            return ResponseEntity.ok(applicationService.getAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    /**
     * Endpoint to create a new application.
     *
     * @param applicationDTO The application data transfer object containing the application details.
     * @return A ResponseEntity containing the created application or an error message.
     */
    @PostMapping(value = "/add")
    public ResponseEntity<?> post(@RequestBody @Valid ApplicationDTO applicationDTO){
        try{
            return applicationService.created(applicationDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    /**
     * Endpoint to update the status of an application.
     *
     * @param id The ID of the application.
     * @param newStatus The new status of the application.
     * @return A ResponseEntity containing the updated application or an error message.
     */
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id,
                                          @RequestBody @Valid String newStatus){
        try{
            return ResponseEntity.ok(applicationService.putStatus(id, newStatus));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

}
package com.example.demo.controller;

import com.example.demo.dto.ApplicationDTO;
import com.example.demo.dto.UpdateApplicationStatusDTO;
import com.example.demo.model.Applications;
import com.example.demo.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controller class for handling application related requests.
 */
@RestController
@RequestMapping(value ="/api/applications")
@Tag(name = "Applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    /**
     * Endpoint to get all applications for a specific user.
     *
     * @param userId The ID of the user.
     * @return A ResponseEntity containing all applications for the user or an error message.
     */
    @Operation(summary = "Lista candidaturas por usuário")
    @GetMapping(value = "/user/{userId}")
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
    @Operation(summary = "Lista candidaturas por vaga")
    @GetMapping(value = "/job/{jobId}")
    public ResponseEntity<?> getAllWithJobId(@PathVariable Long jobId){
        try{
            return ResponseEntity.ok(applicationService.getAllWithJobId(jobId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    /**
     * Endpoint to get all applications.
     *
     * @return A ResponseEntity containing all applications or an error message.
     */
    @Operation(summary = "Lista todas as candidaturas")
    @GetMapping
    public ResponseEntity<?> get(){
        try{
            return ResponseEntity.ok(applicationService.getAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    /**
     * Endpoint to get one application by id.
     *
     * @param id The ID of the application.
     * @return A ResponseEntity containing the application or an error message.
     */
    @Operation(summary = "Busca candidatura por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(applicationService.getById(id));
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
    @Operation(summary = "Cria uma candidatura")
    @PostMapping
    public ResponseEntity<?> post(@RequestBody @Valid ApplicationDTO applicationDTO){
        try{
            return ResponseEntity.ok(applicationService.created(applicationDTO));
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
    @Operation(summary = "Atualiza o status de uma candidatura")
    @PatchMapping(value = "/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id,
                                          @RequestBody @Valid UpdateApplicationStatusDTO statusDTO){
        try{
            Applications updated = applicationService.putStatus(id, statusDTO.status());
            return ResponseEntity.ok(updated);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

}
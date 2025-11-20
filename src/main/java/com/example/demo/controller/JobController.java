package com.example.demo.controller;

import com.example.demo.dto.JobDTO;
import com.example.demo.model.Jobs;
import com.example.demo.service.JobService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling job related requests.
 */
@RestController
@RequestMapping(value = "/api/jobs")
@Tag(name = "Jobs")
public class JobController {

    /**
     * Service class for handling job related operations.
     */
    @Autowired
    private JobService jobService;

    /**
     * Endpoint to get all jobs.
     *
     * @return A ResponseEntity containing all jobs or an error message.
     */
    @Operation(summary = "Lista todas as vagas")
    @GetMapping
    public ResponseEntity<?> getAllJobs (){
        try{
            return ResponseEntity.ok(jobService.getAllJobs());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    /**
     * Endpoint to get all active jobs.
     *
     * @return A ResponseEntity containing the active jobs or an error message.
     */
    @Operation(summary = "Lista vagas ativas")
    @GetMapping(value = "/active")
    public ResponseEntity<?> getActiveJobs(){
        try{
            return ResponseEntity.ok(jobService.getActiveJobs());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    /**
     * Endpoint to get a specific job by its ID.
     *
     * @param id The ID of the job.
     * @return A ResponseEntity containing the job or an error message.
     */
    @Operation(summary = "Busca vaga por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getJob (@PathVariable Long id){
        try{
            return ResponseEntity.ok(jobService.getJob(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    /**
     * Endpoint to create a new job.
     *
     * @param JobDTO The job data transfer object containing the job details.
     * @return A ResponseEntity containing the created job or an error message.
     */
    @Operation(summary = "Cria uma vaga")
    @PostMapping
    public ResponseEntity<?> postJob(@RequestBody @Valid JobDTO JobDTO){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(jobService.created(JobDTO));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }

    /**
     * Endpoint to update a job.
     *
     * @param id The ID of the job.
     * @param JobDTO The job data transfer object containing the updated job details.
     * @return A ResponseEntity containing the updated job or an error message.
     */
    @Operation(summary = "Atualiza uma vaga")
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody @Valid JobDTO JobDTO){
        try{
            var jobs = jobService.update(id, JobDTO);
            return ResponseEntity.ok(jobs);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }
}
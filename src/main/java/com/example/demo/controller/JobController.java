package com.example.demo.controller;

import com.example.demo.dto.JobDTO;
import com.example.demo.model.Jobs;
import com.example.demo.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller class for handling job related requests.
 */
@RestController
@RequestMapping(value = "job")
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
    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllJobs (){
        try{
            return ResponseEntity.ok(jobService.getAllJobs());
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
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getJob (@PathVariable Long id){
        try{
            Optional<Jobs> job = jobService.getJob(id);
            if (job.isEmpty()) return ResponseEntity.badRequest().body("Id not found");

            return ResponseEntity.ok(job.get());
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
    @PostMapping(value = "/add")
    public ResponseEntity<?> postJob(@RequestBody @Valid JobDTO JobDTO){
        try{
            return ResponseEntity.ok(jobService.created(JobDTO));
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
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody @Valid JobDTO JobDTO){
        try{
            var jobs = jobService.update(id, JobDTO);
            if (jobs == null) return ResponseEntity.badRequest().body("Id not found");

            return ResponseEntity.ok(jobs);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Request failed: " + e.getMessage());
        }
    }
}
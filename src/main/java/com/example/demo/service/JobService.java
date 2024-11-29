package com.example.demo.service;

import com.example.demo.dto.JobDTO;
import com.example.demo.model.Jobs;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public List<Jobs> getAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<Jobs> getJob(Long id ) {
        return jobRepository.findById(id);
    }


    public Jobs created(JobDTO jobDTO) {
        Jobs job = new Jobs(jobDTO.title(), jobDTO.description(), jobDTO.requirements(), true);
        jobRepository.save(job);
        return job;
    }

    public Jobs update(Long id, JobDTO jobDTO) {
        Optional<Jobs> jobs = jobRepository.findById(id);

         if (jobs.isEmpty())
             return null;

        Jobs jobOld = jobs.get();
        jobOld.setDescription(jobDTO.description());
        jobOld.setRequirements(jobDTO.requirements());
        jobOld.setTitle(jobDTO.title());
        jobOld.setActive(jobDTO.isActive());
        jobRepository.saveAndFlush(jobOld);

        return jobOld;
    }

}





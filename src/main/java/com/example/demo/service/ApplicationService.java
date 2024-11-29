package com.example.demo.service;

import com.example.demo.dto.ApplicationDTO;
import com.example.demo.model.ApplicationStatus;
import com.example.demo.model.Applications;
import com.example.demo.model.Jobs;
import com.example.demo.model.User;
import com.example.demo.repository.ApplicationsRepository;
import com.example.demo.repository.JobRepository;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired
    ApplicationsRepository applicationsRepository;

    @Autowired
    UserRepository usersRepository;

    @Autowired
    JobRepository jobsRepository;

    private static final Logger log = LoggerFactory.getLogger(ApplicationService.class);

    public List<Applications> getAll() {

        return null;
    }

    public ResponseEntity<?> created(ApplicationDTO applicationDTO) {
        log.info("Init Created application");

        Optional<User> user = usersRepository.findById(applicationDTO.userId());
        if (user.isEmpty()) {
            log.error("User not found");
            return ResponseEntity.badRequest().body("User not found");
        }

        Optional<Jobs> job = jobsRepository.findById(applicationDTO.jobId());
        if (job.isEmpty()) {
            log.error("Job not found");
            return ResponseEntity.badRequest().body("Job not found");
        }

        Applications application = new Applications(user.get(), job.get(), new Date(), applicationDTO.status());


        applicationsRepository.saveAndFlush(application);
        return ResponseEntity.ok(application);
    }

    public ResponseEntity<?> getAllWithUserId(Long userId) {
        log.info("get all applications with the user " + userId);

        Optional<User> user = usersRepository.findById(userId);
        if (user.isEmpty()) {
            log.error("User not found");
            return ResponseEntity.badRequest().body("User not found");
        }

        List<Applications> applications = applicationsRepository.findAllByUserId(user.get());
        return ResponseEntity.ok(applications);
    }

    public ResponseEntity<?> getAllWithJobId(Long jobId) {
        log.info("get all applications with the job " + jobId);

        Optional<Jobs> job = jobsRepository.findById(jobId);
        if (job.isEmpty()) {
            log.error("Job not found");
            return ResponseEntity.badRequest().body("Job not found");
        }

        List<Applications> applications = applicationsRepository.findAllByJobId(job.get());
        return ResponseEntity.ok(applications);
    }

    public Applications putStatus(Long id, String newStatus) {
       log.info("Update status of application");

       Optional<Applications> applications = applicationsRepository.findById(id);
       if (applications.isEmpty()){
           log.error("Application not found");
           return null;
       }
       applications.get().setStatus(ApplicationStatus.valueOf(newStatus));
       applicationsRepository.saveAndFlush(applications.get());
       return applications.get();
    }
}







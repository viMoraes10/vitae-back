package com.example.demo.repository;

import com.example.demo.model.Applications;
import com.example.demo.model.Jobs;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationsRepository extends JpaRepository<Applications, Long> {
    List<Applications> findAllByJobId(Jobs jobId);

    List<Applications> findAllByUserId(User user);
}

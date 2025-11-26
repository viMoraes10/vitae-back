package com.example.demo.service;

import com.example.demo.dto.OccurrenceDTO;
import com.example.demo.model.Report;
import com.example.demo.model.User;
import com.example.demo.repository.ReportRepository;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OccurrenceService {

    private static final Logger log = LoggerFactory.getLogger(OccurrenceService.class);

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Report> getAllOccurrences() {
        return reportRepository.findAll();
    }

    public Report getOccurrenceById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Occurrence not found"));
    }

    public Report createOccurrence(OccurrenceDTO occurrenceDTO) {
        log.info("Creating occurrence for user {}", occurrenceDTO.userId());
        User reporter = userRepository.findById(occurrenceDTO.userId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));

        Report report = new Report();
        report.setUserId(reporter.getId());
        report.setReportType(occurrenceDTO.reportType());
        report.setDescription(occurrenceDTO.description());

        return reportRepository.save(report);
    }

    public Report updateStatus(Long id, String status) {
        log.info("Updating occurrence {} to status {}", id, status);
        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Occurrence not found"));

        report.setStatus(status);
        return reportRepository.save(report);
    }
}

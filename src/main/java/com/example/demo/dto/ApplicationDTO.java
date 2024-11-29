package com.example.demo.dto;

import com.example.demo.model.ApplicationStatus;

import java.util.Date;

public record ApplicationDTO(Long id, Long userId, Long jobId, Date applicationDate, ApplicationStatus status) {
}

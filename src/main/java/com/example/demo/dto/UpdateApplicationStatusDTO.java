package com.example.demo.dto;

import com.example.demo.model.ApplicationStatus;

import jakarta.validation.constraints.NotNull;

public record UpdateApplicationStatusDTO(@NotNull ApplicationStatus status) {
}

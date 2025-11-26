package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OccurrenceDTO(
        @NotNull Long userId,
        @NotBlank String reportType,
        @NotBlank String description
) {}

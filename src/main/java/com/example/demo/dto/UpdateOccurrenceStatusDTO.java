package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateOccurrenceStatusDTO(
        @NotBlank String status
) {}

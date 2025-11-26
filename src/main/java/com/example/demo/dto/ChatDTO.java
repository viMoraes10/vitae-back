package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ChatDTO(
        @NotNull Integer userId,
        @NotBlank String message,
        @NotBlank String sender
) {
}

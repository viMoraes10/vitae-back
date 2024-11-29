package com.example.demo.dto;

import com.example.demo.model.UserRole;

public record RegisterDTO(String username, String password, UserRole role, String email)  {
}

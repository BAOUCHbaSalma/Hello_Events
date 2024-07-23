package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record Login(
        @Schema(description = "username", example = "imane")
        @NotBlank(message = "Username cannot be blank")
        @Size(min = 1, max = 50, message = "Username must be between 3 and 50 characters")
        String username,

        @Schema(description = "password", example = "imane")
        @NotBlank(message = "Password cannot be blank")
        @Size(min = 1, max = 20, message = "Password must be between 6 and 20 characters")
        String password
) {
}
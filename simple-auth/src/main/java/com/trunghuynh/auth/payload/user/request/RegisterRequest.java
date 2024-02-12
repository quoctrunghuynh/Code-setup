package com.trunghuynh.auth.payload.user.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "username is required.")
    @Size(min = 8, max = 20, message = "username must between 8 - 20 characters")
    private String username;

    @NotBlank(message = "password is required")
    @Size(min = 8, max = 20, message = "password must between 8 - 20 characters")
    private String password;

    @NotBlank(message = "firstname is required")
    @Size(max = 20, message = "firstname must lower 20 characters")
    private String firstname;

    @NotBlank(message = "lastname is required")
    @Size(max = 20, message = "lastname must lower 20 characters")
    private String lastname;
}

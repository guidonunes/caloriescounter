package br.com.fiap.caloriescounter.dto;

import br.com.fiap.caloriescounter.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserDTO(
        Long userId,

        @NotBlank(message = "User name cannot be blank.")
        String name,

        @NotBlank(message = "Email field cannot be blank.")
        @Email(message = "Invalid email format.")
        String email,

        @NotBlank(message = "Password cannot be blank.")
        @Size(min = 6, max = 20, message = "Password length must be between 6 and 20 characters.")
        String password
) {

}

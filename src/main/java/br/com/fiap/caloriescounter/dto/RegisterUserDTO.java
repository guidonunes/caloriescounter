package br.com.fiap.caloriescounter.dto;

import br.com.fiap.caloriescounter.model.User;

public record RegisterUserDTO(
        Long userId,
        String name,
        String email,
        String password
) {

}

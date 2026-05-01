package br.com.fiap.caloriescounter.dto;

import br.com.fiap.caloriescounter.model.User;

public record ShowUserDTO(
        Long userId,
        String name,
        String email
){
    public ShowUserDTO(User user) {
        this(
                user.getUserId(),
                user.getName(),
                user.getEmail()
        );
    }


}

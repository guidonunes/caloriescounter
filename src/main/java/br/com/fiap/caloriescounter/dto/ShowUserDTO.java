package br.com.fiap.caloriescounter.dto;

import br.com.fiap.caloriescounter.model.User;
import br.com.fiap.caloriescounter.model.UserRole;

public record ShowUserDTO(
        Long userId,
        String name,
        String email,
        UserRole role
){
    public ShowUserDTO(User user) {
        this(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }


}

package br.com.fiap.caloriescounter.controller;

import br.com.fiap.caloriescounter.dto.RegisterUserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login (
            @RequestBody
            @Valid
            RegisterUserDTO userDTO

    ) {
        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        userDTO.email(), userDTO.password()
                );
        Authentication auth = authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok(auth.getPrincipal());
    }
}

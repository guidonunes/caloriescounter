package br.com.fiap.caloriescounter.controller;

import br.com.fiap.caloriescounter.dto.RegisterUserDTO;
import br.com.fiap.caloriescounter.dto.ShowUserDTO;
import br.com.fiap.caloriescounter.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

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

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity register(@RequestBody @Valid RegisterUserDTO userDTO) {
        ShowUserDTO savedUser = null;

        savedUser = userService.saveUser(userDTO);

        return ResponseEntity.ok(savedUser);
    }
}

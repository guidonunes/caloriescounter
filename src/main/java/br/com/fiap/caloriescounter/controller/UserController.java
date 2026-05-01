package br.com.fiap.caloriescounter.controller;


import br.com.fiap.caloriescounter.dto.ShowUserDTO;
import br.com.fiap.caloriescounter.model.User;
import br.com.fiap.caloriescounter.repository.UserRepository;
import br.com.fiap.caloriescounter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<ShowUserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ShowUserDTO> getUserById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId){
        userService.deleteUserById(userId);
    }

    @PutMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
}

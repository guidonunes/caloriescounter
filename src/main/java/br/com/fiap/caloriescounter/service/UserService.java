package br.com.fiap.caloriescounter.service;

import br.com.fiap.caloriescounter.model.User;
import br.com.fiap.caloriescounter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        Optional<User> optionalUser =userRepository.findById(id);

        if(optionalUser.isPresent()){
            return optionalUser.get();
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()){
            userRepository.delete(optionalUser.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public User updateUser(User user){
        Optional<User> optionalUser = userRepository.findById(user.getUserId());

        if(optionalUser.isPresent()){
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}

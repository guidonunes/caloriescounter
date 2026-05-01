package br.com.fiap.caloriescounter.service;

import br.com.fiap.caloriescounter.dto.RegisterUserDTO;
import br.com.fiap.caloriescounter.dto.ShowUserDTO;
import br.com.fiap.caloriescounter.model.User;
import br.com.fiap.caloriescounter.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ShowUserDTO saveUser(RegisterUserDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        User userSaved = userRepository.save(user);
        return new ShowUserDTO(userSaved);
    }

    public ShowUserDTO getUserById(Long id){
        Optional<User> optionalUser =userRepository.findById(id);


        if(optionalUser.isPresent()){
            return new ShowUserDTO(optionalUser.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<ShowUserDTO> getAllUsers(){
        return userRepository
                .findAll()
                .stream()
                .map(ShowUserDTO::new)
                .toList();
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

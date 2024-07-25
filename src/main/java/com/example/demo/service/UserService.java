package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;



    public User findUserById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User signUp(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public User updateProfile(Integer userId, User user) {
        User existingUser = findUserById(userId);
        existingUser.setEmail(user.getEmail());
        existingUser.setAge(user.getAge());
        return userRepository.save(existingUser);
    }

    public List<User> findAllRegistre(){
       return userRepository.findAll();
    }
    public void deleteUser(Integer idUser){
        userRepository.deleteById(idUser);
    }


}

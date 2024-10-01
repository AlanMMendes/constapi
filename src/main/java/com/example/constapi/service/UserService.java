package com.example.constapi.service;

import com.example.constapi.model.User;
import com.example.constapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }



    public User createUser(User user) {
       user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("Added User");
        return userRepository.save(user);
    }


}

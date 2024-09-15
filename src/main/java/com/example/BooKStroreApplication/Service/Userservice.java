package com.example.BooKStroreApplication.Service;

import com.example.BooKStroreApplication.Model.User;
import com.example.BooKStroreApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userservice {

    @Autowired
    private UserRepository userRepository;

    // Save user to the database
    public void save(User user) {
        userRepository.save(user);
    }

    // Find user by name
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}

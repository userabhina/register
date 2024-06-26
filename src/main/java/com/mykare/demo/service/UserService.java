package com.mykare.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mykare.demo.entity.User;
import com.mykare.demo.repository.Userrepository;



@Service
public class UserService {
    @Autowired
    private Userrepository userRepository;

    public User registerUser(User newUser) {
        // Implement logic to check if email is unique before saving
        return userRepository.save(newUser);
    }

    public boolean validateUser(String email, String password) {
        // Implement logic to validate user credentials
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent() && user.get().getPassword().equals(password);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserByEmail(String email) {
    	Optional<User> userOptional = userRepository.findByEmail(email);
    	if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
        } else {
            throw new IllegalArgumentException("User with email " + email + " not found");
        }

    }
}


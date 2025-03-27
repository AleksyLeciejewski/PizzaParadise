package com.example.pizzaparadise.Application;

import com.example.pizzaparadise.Domain.User;
import com.example.pizzaparadise.InfraStructure.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String password, String email) {
        User newUser = new User(username, password, email, null);
        return userRepository.saveUser(newUser);
    }
}

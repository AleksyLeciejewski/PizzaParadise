package com.example.pizzaparadise.InfraStructure;

import com.example.pizzaparadise.Domain.User;
import java.util.List;

public interface UserRepoInt {

    User saveUser(User user);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(String username);
}

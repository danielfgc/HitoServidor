package com.springbootrestapi.services;

import com.springbootrestapi.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getOneUser(int id);
    Boolean getUserByEmail(String email);
    User updateUser(User user, int id);
    void deleteUser(int id);
}

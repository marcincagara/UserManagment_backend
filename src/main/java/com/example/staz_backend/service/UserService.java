package com.example.staz_backend.service;

import com.example.staz_backend.entity.User;


import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void deleteUser(Integer id);
    void updateUser(User user);
    User getUserById(Integer id);
    void saveUser(User user);
}

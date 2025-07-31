package com.hos.service;

import com.hos.model.User;

public interface UserService {
    boolean registerUser(User user);
    void saveUser(User user);
    User findByEmail(String email);
    boolean login(String username, String password);
}
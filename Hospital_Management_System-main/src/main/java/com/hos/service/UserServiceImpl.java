package com.hos.service;

import com.hos.model.User;
import com.hos.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean registerUser(User user) {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            return false;
        }
        userRepo.save(user);
        return true;
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public boolean login(String username, String password) {
        User user = userRepo.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}

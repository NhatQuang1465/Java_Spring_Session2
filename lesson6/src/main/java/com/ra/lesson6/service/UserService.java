package com.ra.lesson6.service;

import com.ra.lesson6.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(int id);
    User createUser(User user);
    User updateUser(int id, User user);
    User deleteUserById(int id);
}
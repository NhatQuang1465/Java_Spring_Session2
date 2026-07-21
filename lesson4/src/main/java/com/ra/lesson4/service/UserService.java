package com.ra.lesson4.service;

import com.ra.lesson4.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(int id);
}
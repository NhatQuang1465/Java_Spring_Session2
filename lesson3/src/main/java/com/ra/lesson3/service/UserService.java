package com.ra.lesson3.service;

import com.ra.lesson3.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
}
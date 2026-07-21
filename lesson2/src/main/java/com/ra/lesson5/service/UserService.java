package com.ra.lesson5.service;

import com.ra.lesson5.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
}
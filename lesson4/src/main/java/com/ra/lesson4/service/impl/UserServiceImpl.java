package com.ra.lesson4.service.impl;
import com.ra.lesson4.model.entity.User;
import com.ra.lesson4.repository.UserRepository;
import com.ra.lesson4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User findUserById(int id) {
        return userRepository.findById(id);
    }
}
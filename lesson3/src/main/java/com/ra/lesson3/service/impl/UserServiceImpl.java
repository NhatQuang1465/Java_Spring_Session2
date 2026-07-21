package com.ra.lesson3.service.impl;
import com.ra.lesson3.model.entity.User;
import com.ra.lesson3.repository.UserRepository;
import com.ra.lesson3.service.UserService;
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
}
package com.ra.lesson6.service.impl;
import com.ra.lesson6.model.entity.User;
import com.ra.lesson6.repository.UserRepository;
import com.ra.lesson6.service.UserService;
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
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, User user) {
        return userRepository.save(id, user);
    }

    @Override
    public User deleteUserById(int id) {
        return userRepository.deleteById(id);
    }
}
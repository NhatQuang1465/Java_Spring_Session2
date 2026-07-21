package com.ra.lesson5.controller;


import com.ra.lesson5.model.entity.User;
import com.ra.lesson5.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> findAllUsers(@RequestParam(name = "search", required = false) String search) {
        List<User> users = userService.findAllUsers();
        if (search != null && !search.trim().isEmpty()) {
            users = users.stream().filter(user -> user.getFullName().toLowerCase().contains(search.toLowerCase().trim())).collect(Collectors.toList());
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(
            @RequestParam(required = false) String search) {

        List<User> users = userService.findAllUsers();

        if (search != null && !search.trim().isEmpty()) {
            users = users.stream()
                    .filter(user -> user.getFullName()
                            .toLowerCase()
                            .contains(search.toLowerCase().trim()))
                    .toList();
        }

        return ResponseEntity.ok(users);
    }
}

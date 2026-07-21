package com.ra.lesson6.controller;


import com.ra.lesson6.model.entity.User;
import com.ra.lesson6.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        User deletedUser = userService.deleteUserById(id);
        if (deletedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

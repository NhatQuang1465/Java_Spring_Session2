package com.ra.lesson6.repository;

import com.ra.lesson6.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepository(List<User> users) {

        this.users.add(new User(1,"Nguyen Duc A","a@gmail.com",19,"USER"));
        this.users.add(new User(2,"Nguyen Van B","a@gmail.com",19,"ADMIN"));
        this.users.add(new User(3,"Nguyen Thi C","a@gmail.com",19,"ADMIN"));
        this.users.add(new User(4,"Cao Duc M","a@gmail.com",19,"ADMIN"));
    }
    public List<User> findAll() {
        return users;
    }
    public User findById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public User save(User user) {
        users.add(user);
        return user;
    }
    public User save(int id, User newUser) {
        User oldUser = findById(id);
        if (oldUser == null) {
            return null;
        }
        oldUser.setFullName(newUser.getFullName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setAge(newUser.getAge());
        oldUser.setRole(newUser.getRole());
        return oldUser;
    }

    public User deleteById(int id) {
        User user = findById(id);
        if (user == null) {
            return null;
        }
        users.remove(user);
        return user;
    }
}
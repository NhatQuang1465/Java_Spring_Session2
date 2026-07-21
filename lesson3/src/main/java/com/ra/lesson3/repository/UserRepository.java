package com.ra.lesson3.repository;

import com.ra.lesson3.model.entity.User;
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
}
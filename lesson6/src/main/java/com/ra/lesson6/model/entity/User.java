package com.ra.lesson6.model.entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String fullName;
    private String email;
    private int age;
    private String role;
}
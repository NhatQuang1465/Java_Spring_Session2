package com.ra.lesson3.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    private int id;
    private String title;
    private String status;
    private String priority;
    private int userId;

}
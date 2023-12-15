package com.codegym.c03demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class User {

    private long id;

    private String username;

    private String password;

    private String name;

    private int age;

    private Address address;

}

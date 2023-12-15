package com.codegym.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    protected int id;
    protected String name;
    protected String email;
    protected String country;
}

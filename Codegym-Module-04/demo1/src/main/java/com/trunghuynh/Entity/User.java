package com.trunghuynh.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

@Builder
@Getter
@Setter

public class User {
    private int id;
    private String lastname;
    private String firstname;
    private String username;

}

package com.codegym.c03demo.dto;

import lombok.Data;

@Data
public class LoginResponseDto {

    private long id;

    private String username;

    private String name;

    private AddressResponseDto address;

}

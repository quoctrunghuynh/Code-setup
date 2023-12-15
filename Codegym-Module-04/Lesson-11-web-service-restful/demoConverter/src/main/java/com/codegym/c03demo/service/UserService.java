package com.codegym.c03demo.service;

import com.codegym.c03demo.dto.LoginRequestDto;
import com.codegym.c03demo.dto.LoginResponseDto;

public interface UserService {
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}

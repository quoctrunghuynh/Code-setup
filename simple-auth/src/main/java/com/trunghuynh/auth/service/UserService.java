package com.trunghuynh.auth.service;

import com.trunghuynh.auth.payload.ResponseDto;
import com.trunghuynh.auth.payload.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseDto save(UserDto userDto);
}

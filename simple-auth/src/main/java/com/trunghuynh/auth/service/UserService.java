package com.trunghuynh.auth.service;

import com.trunghuynh.auth.payload.ResponseDto;
import com.trunghuynh.auth.payload.user.request.UserUpdateRequest;
import com.trunghuynh.auth.payload.user.response.UserDto;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    Object get(Long id);
    ResponseDto update(UserUpdateRequest userUpdateRequest);
    ResponseDto delete(String token, HttpServletRequest request);
}

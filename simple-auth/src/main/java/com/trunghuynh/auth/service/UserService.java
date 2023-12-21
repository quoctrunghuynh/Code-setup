package com.trunghuynh.auth.service;

import com.trunghuynh.auth.payload.ResponseDto;
import com.trunghuynh.auth.payload.user.request.UserUpdateRequest;
import com.trunghuynh.auth.payload.user.response.UserDto;

public interface UserService {
    UserDto get(Long id);
    ResponseDto update(UserUpdateRequest userUpdateRequest);
    ResponseDto delete(Long id);
}

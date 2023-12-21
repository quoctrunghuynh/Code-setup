package com.trunghuynh.auth.service;

import com.trunghuynh.auth.payload.ResponseDto;
import com.trunghuynh.auth.payload.user.request.AuthenticateRequest;
import com.trunghuynh.auth.payload.user.request.RegisterRequest;

public interface AuthService {
    ResponseDto register(RegisterRequest userDto);

    ResponseDto authenticate(AuthenticateRequest userDto);
}

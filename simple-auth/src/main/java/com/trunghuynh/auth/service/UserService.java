package com.trunghuynh.auth.service;

import com.trunghuynh.auth.payload.ResponseDto;
import com.trunghuynh.auth.payload.user.request.UserUpdateRequest;
import com.trunghuynh.auth.payload.user.response.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface UserService {
    Object get(Long id);
    ResponseDto update(UserUpdateRequest userUpdateRequest);
    ResponseDto delete(String token, HttpServletRequest request);

//    ResponseDto getAll(Pageable pageable);
}

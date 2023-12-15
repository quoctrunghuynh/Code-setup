package com.trunghuynh.casestudy.model.service.user;

import com.trunghuynh.casestudy.model.dto.request.RegisterRequest;
import com.trunghuynh.casestudy.model.dto.response.UserResponseDto;
import com.trunghuynh.casestudy.model.entity.user.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    void save(RegisterRequest request);

    UserResponseDto getEmailFromToken(String token);
}

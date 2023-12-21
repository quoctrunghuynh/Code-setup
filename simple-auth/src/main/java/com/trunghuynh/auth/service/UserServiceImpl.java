package com.trunghuynh.auth.service;

import com.trunghuynh.auth.configuration.security.JwtService;
import com.trunghuynh.auth.entity.User;
import com.trunghuynh.auth.payload.ResponseDto;
import com.trunghuynh.auth.payload.user.request.UserUpdateRequest;
import com.trunghuynh.auth.payload.user.response.UserDto;
import com.trunghuynh.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;

    @Override
    public UserDto get(Long id) {
        Optional<User> userData = userRepository.findUserByIdAndIsDeletedIsFalse(id);
        return userData.map(
                user -> UserDto.builder()
                        .id(user.getId())
                        .firstname(user.getFirstname())
                        .lastname(user.getLastname())
                        .createdAt(user.getCreatedAt())
                        .build()).orElse(null);
    }

    @Override
    public ResponseDto update(UserUpdateRequest userUpdateRequest) {
        User user = userRepository
                .findUserByIdAndIsDeletedIsFalse(userUpdateRequest.getId())
                .stream()
                .findFirst()
                .orElse(null);
        if (user != null) {
            user.setFirstname(userUpdateRequest.getFirstname());
            user.setLastname(userUpdateRequest.getLastname());
            userRepository.save(user);
            return ResponseDto.builder()
                    .status("200")
                    .message("User updated successfully")
                    .data(true)
                    .build();
        }
        return ResponseDto.builder()
                .status("400")
                .message("User updated failed")
                .data(false)
                .build();
    }

    @Override
    public ResponseDto delete(Long id) {

        if (user != null) {
            user.setIsDeleted(true);
            userRepository.save(user);
            return ResponseDto.builder()
                    .status("200")
                    .message("User deleted successfully")
                    .data(true)
                    .build();
        }
        return ResponseDto.builder()
                .status("400")
                .message("User not found or has been deleted")
                .data(false)
                .build();
    }
}

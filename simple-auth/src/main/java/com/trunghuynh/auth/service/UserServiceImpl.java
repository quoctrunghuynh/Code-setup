package com.trunghuynh.auth.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trunghuynh.auth.configuration.security.JwtAuthenticationFilter;
import com.trunghuynh.auth.configuration.security.JwtService;
import com.trunghuynh.auth.entity.User;
import com.trunghuynh.auth.payload.ResponseDto;
import com.trunghuynh.auth.payload.user.request.UserUpdateRequest;
import com.trunghuynh.auth.payload.user.response.UserDto;
import com.trunghuynh.auth.repository.UserRepository;
import com.trunghuynh.auth.repository.redis.UserDtoRedisRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserRepository userRepository;
    private final UserDtoRedisRepository userDtoRedisRepository;
    private final JwtService jwtService;
    private final ObjectMapper objectMapper;

    @Override
    public Object get(Long id) {
        User userInCache = (User) userDtoRedisRepository.findUserDtoWithId(id);
        if (userInCache == null) {
            Optional<User> userData = userRepository.findUserByIdAndIsDeletedIsFalse(id);
            if (userData.isEmpty()) {
                return ResponseDto.builder()
                        .status("200")
                        .message("User not found! Please try again later.")
                        .data(false)
                        .build();
            } else {
                UserDto userDtoInRepository = userData.map(
                        user -> UserDto.builder()
                                .id(user.getId())
                                .firstname(user.getFirstname())
                                .lastname(user.getLastname())
                                .createdAt(user.getCreatedAt())
                                .build()).orElse(null);
                userDtoRedisRepository.saveUserDto(userDtoInRepository);
                return userDtoInRepository;
            }
        }
        return objectMapper.convertValue(userInCache, UserDto.class);
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
            userDtoRedisRepository.updateUserDtoByUser(user);
            return ResponseDto.builder()
                    .status("200")
                    .message("User updated successfully!")
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
    public ResponseDto delete(String token, HttpServletRequest request) {
        String jwt = jwtAuthenticationFilter.getJwtFromRequest(request);
        if (jwt.equals(token)) {
            String username = jwtService.extractUsername(token);
            User user = userRepository.findUserByUsername(username).orElse(null);
            if (user != null) {
                user.setIsDeleted(true);
                userRepository.save(user);
                userDtoRedisRepository.deleteUserDtoByUser(user);
                return ResponseDto.builder()
                        .status("200")
                        .message("User deleted successfully!")
                        .data(true)
                        .build();
            }
        }
        return ResponseDto.builder()
                .status("400")
                .message("User not found or has been deleted!")
                .data(false)
                .build();
    }
}

package com.trunghuynh.auth.service;

import com.trunghuynh.auth.payload.ResponseDto;
import lombok.RequiredArgsConstructor;
import com.trunghuynh.auth.entity.User;
import com.trunghuynh.auth.payload.UserDto;
import com.trunghuynh.auth.converter.UserConverter;
import com.trunghuynh.auth.repository.UserRepository;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserConverter userConverter;
    private final UserRepository userRepository;

    @Override
    public ResponseDto save(UserDto userDto) {
        User user = userConverter.revert(userDto);
        if (user != null) {
            userRepository.save(user);
            return ResponseDto.builder()
                    .message("Save user successfully!")
                    .status("201").data(true)
                    .build();
        }
        return ResponseDto.builder()
                .message("Save user failed!")
                .status("401").data(false)
                .build();
    }
}

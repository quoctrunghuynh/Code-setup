package com.trunghuynh.auth.controller;

import com.trunghuynh.auth.payload.ResponseDto;
import com.trunghuynh.auth.payload.UserDto;
import com.trunghuynh.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseDto register(@RequestBody UserDto userDto){
       return userService.save(userDto);
    }

}

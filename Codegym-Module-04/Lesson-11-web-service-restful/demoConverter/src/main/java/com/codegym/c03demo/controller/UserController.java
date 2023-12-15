package com.codegym.c03demo.controller;

import com.codegym.c03demo.dto.LoginRequestDto;
import com.codegym.c03demo.dto.LoginResponseDto;
import com.codegym.c03demo.service.UserService;
import com.sun.net.httpserver.Headers;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto){
        LoginResponseDto user = userService.login(loginRequestDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}

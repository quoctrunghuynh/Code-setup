package com.trunghuynh.casestudy.controller;

import com.trunghuynh.casestudy.model.dto.response.UserResponseDto;
import com.trunghuynh.casestudy.model.service.user.UserService;
import com.trunghuynh.casestudy.model.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/data")
    public ResponseEntity<UserResponseDto> getUserFromToken(@RequestHeader("Authorization") final String authToken){
        System.out.println(authToken);
        UserResponseDto user = userService.getEmailFromToken(authToken);
        if(user != null){
            System.err.println(user.getEmail());
            return  new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }


}

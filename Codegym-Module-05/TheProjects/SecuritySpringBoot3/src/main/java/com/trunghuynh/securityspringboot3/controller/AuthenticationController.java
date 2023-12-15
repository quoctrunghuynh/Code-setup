package com.trunghuynh.securityspringboot3.controller;

import com.trunghuynh.securityspringboot3.entity.model.request.AuthenticationRequest;
import com.trunghuynh.securityspringboot3.entity.model.request.RegisterRequest;
import com.trunghuynh.securityspringboot3.entity.model.response.AuthenticationResponse;
import com.trunghuynh.securityspringboot3.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register
            (@RequestBody RegisterRequest request){
        return ResponseEntity.ok((service.register(request)));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate
            (@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }
}

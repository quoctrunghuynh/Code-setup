package com.trunghuynh.casestudy.controller;

import com.trunghuynh.casestudy.model.dto.request.AuthRequest;
import com.trunghuynh.casestudy.model.dto.request.RegisterRequest;
import com.trunghuynh.casestudy.model.dto.response.AuthResponse;
import com.trunghuynh.casestudy.model.service.auth.AuthService;
import com.trunghuynh.casestudy.model.service.logout.LogOutService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final LogOutService logOutService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Email or password is wrong!!!", HttpStatus.BAD_REQUEST);
        } else {
            authService.register(request);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request, HttpServletResponse response) {
        try {
            AuthResponse authResponse = authService.authenticate(request, response);
            return new ResponseEntity<>(authResponse, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody String accessToken) {
        if (accessToken != null && !accessToken.equals("undefined")) {
            AuthResponse authResponse = authService.refreshToken(accessToken);
            if (authResponse != null) {
                return new ResponseEntity<>(authResponse, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/logout")
    public void logout(){
       SecurityContextHolder.clearContext();
    }
}

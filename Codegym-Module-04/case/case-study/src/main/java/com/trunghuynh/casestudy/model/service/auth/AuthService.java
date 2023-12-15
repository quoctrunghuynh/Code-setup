package com.trunghuynh.casestudy.model.service.auth;

import com.trunghuynh.casestudy.Jwt.JwtService;
import com.trunghuynh.casestudy.model.dto.request.AuthRequest;
import com.trunghuynh.casestudy.model.dto.request.RegisterRequest;
import com.trunghuynh.casestudy.model.dto.response.AuthResponse;
import com.trunghuynh.casestudy.model.entity.user.Role;
import com.trunghuynh.casestudy.model.entity.user.User;
import com.trunghuynh.casestudy.model.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        User user;
        if (userRepository.findByEmail(request.getEmail()).isEmpty()) {
            user = User.builder()
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
            userRepository.save(user);
        } else {
            user = null;
        }
        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        return AuthResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthResponse authenticate(AuthRequest request, HttpServletResponse response) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElse(null);
        if (user != null) {
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwtToken = jwtService.generateToken(user);
                String refreshToken = jwtService.generateRefreshToken(user);
                response.addHeader("Authorization", "Bearer " + jwtToken);
                return AuthResponse.builder()
                        .accessToken(jwtToken)
                        .refreshToken(refreshToken)
                        .build();
            }
        }
        return null;
    }

    public AuthResponse refreshToken(String accessToken) {
        if (!jwtService.isTokenExpired(accessToken)) {
            String userEmail = jwtService.extractUsername(accessToken);
            User user = userRepository.findByEmail(userEmail).orElse(null);
            if (user != null && jwtService.isTokenValid(accessToken, user)) {
                String newAccessToken = jwtService.generateToken(user);
                return new AuthResponse(newAccessToken, null, user.getId(), userEmail);
            }
        }
        return null;
    }
}

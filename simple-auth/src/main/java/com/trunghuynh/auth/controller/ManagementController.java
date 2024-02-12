package com.trunghuynh.auth.controller;

import com.trunghuynh.auth.payload.ResponseDto;
import com.trunghuynh.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/management/")
public class ManagementController {
    private final UserService userService;

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('management:read')")
    public ResponseEntity<ResponseDto> getAllUser(Pageable pageable){
        return ResponseEntity.ok(userService.getAll(pageable));
    }
}

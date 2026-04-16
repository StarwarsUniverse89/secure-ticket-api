package com.fmelgoza.secureticketapi.controller;

import com.fmelgoza.secureticketapi.dto.AuthResponse;
import com.fmelgoza.secureticketapi.dto.LoginRequest;
import com.fmelgoza.secureticketapi.dto.RegisterRequest;
import com.fmelgoza.secureticketapi.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
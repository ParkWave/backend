package com.parkWave.backend.controller;

import com.parkWave.backend.dto.JwtRequestDto;
import com.parkWave.backend.dto.JwtResponseDto;
import com.parkWave.backend.dto.MemberSignupRequestDto;
import com.parkWave.backend.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    public JwtResponseDto login(@RequestBody JwtRequestDto request) {

        try {
            return authService.login(request);
        } catch (Exception e) {
            return new JwtResponseDto(e.getMessage());
        }
    }

    @PostMapping(value = "signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public String signup(@RequestBody MemberSignupRequestDto request) {
        return authService.signup(request);
    }

    @GetMapping("dashboard")
    public String dashboard() {
        return "dashboard";
    }



}
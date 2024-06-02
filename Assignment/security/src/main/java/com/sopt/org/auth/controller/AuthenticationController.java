package com.sopt.org.auth.controller;

import com.sopt.org.auth.redis.service.AuthenticationService;
import com.sopt.org.auth.redis.service.RefreshTokenService;
import com.sopt.org.auth.redis.service.dto.LoginRequest;
import com.sopt.org.auth.redis.service.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = authenticationService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<LoginResponse> refreshToken(@RequestBody String refreshToken) {
        String newAccessToken = refreshTokenService.reissueAccessToken(refreshToken);
        return ResponseEntity.ok(new LoginResponse(newAccessToken, refreshToken));
    }
}
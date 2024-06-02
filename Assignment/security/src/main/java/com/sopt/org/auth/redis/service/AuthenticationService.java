package com.sopt.org.auth.redis.service;

import com.sopt.org.auth.UserAuthentication;
import com.sopt.org.auth.redis.service.dto.LoginRequest;
import com.sopt.org.auth.redis.service.dto.LoginResponse;
import com.sopt.org.common.jwt.JwtTokenProvider;
import com.sopt.org.domain.Member;
import com.sopt.org.exception.UnauthorizedException;
import com.sopt.org.exception.message.ErrorMessage;
import com.sopt.org.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final RefreshTokenService refreshTokenService;

    @Transactional
    public LoginResponse login(LoginRequest loginRequest) {
        Member member = memberRepository.findByName(loginRequest.name()).orElseThrow(
                () -> new UnauthorizedException(ErrorMessage.INVALID_USERNAME_OR_PASSWORD)
        );

        if(!passwordEncoder.matches(loginRequest.password(), member.getPassword())) {
            throw new UnauthorizedException(ErrorMessage.INVALID_USERNAME_OR_PASSWORD);
        }

        Long memberId = member.getId();
        String accessToken = jwtTokenProvider.issueAccessToken(UserAuthentication.createUserAuthentication(memberId));
        String refreshToken = jwtTokenProvider.issueRefreshToken(UserAuthentication.createUserAuthentication(memberId));

        refreshTokenService.saveRefreshToken(memberId, refreshToken);

        return new LoginResponse(accessToken, refreshToken);
    }
}

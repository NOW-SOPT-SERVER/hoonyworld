package com.sopt.org.auth.redis.service;

import com.sopt.org.auth.UserAuthentication;
import com.sopt.org.auth.redis.domain.Token;
import com.sopt.org.auth.redis.repository.RedisTokenRepository;
import com.sopt.org.auth.redis.service.dto.TokenRefreshResponse;
import com.sopt.org.common.jwt.JwtTokenProvider;
import com.sopt.org.exception.NotFoundException;
import com.sopt.org.exception.message.ErrorMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final RedisTokenRepository redisTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void saveRefreshToken(Long userId, String refreshToken) {
        redisTokenRepository.save(Token.of(userId, refreshToken));
    }

    @Transactional
    public TokenRefreshResponse reissueTokens(String refreshToken) {
        Token token = redisTokenRepository.findByRefreshToken(refreshToken).orElseThrow(
                () -> new NotFoundException(ErrorMessage.REFRESH_TOKEN_NOT_FOUND));

        Long userId = token.getId();
        Authentication authentication = UserAuthentication.createUserAuthentication(userId);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String newAccessToken = jwtTokenProvider.issueAccessToken(authentication);
        String newRefreshToken = jwtTokenProvider.issueRefreshToken(authentication);

        saveRefreshToken(userId, newRefreshToken);

        return new TokenRefreshResponse(newAccessToken, newRefreshToken);
    }

//    @Transactional
//    public void deleteRefreshToken(Long userId) {
//        Token token = redisTokenRepository.findById(userId)
//                .orElseThrow(() -> new NotFoundException(ErrorMessage.REFRESH_TOKEN_NOT_FOUND));
//        redisTokenRepository.delete(token);
//    }
}
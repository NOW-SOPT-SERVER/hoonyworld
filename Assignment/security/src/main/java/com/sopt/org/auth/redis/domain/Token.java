package com.sopt.org.auth.redis.domain;

import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "refreshToken", timeToLive = 60 * 60 * 24 * 14) // 14일을 초 단위로 설정
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Token {

    @Id
    private Long id;

    @Indexed
    private String refreshToken;

    @Builder
    private Token(Long id, String refreshToken) {
        this.id = id;
        this.refreshToken = refreshToken;
    }

    public static Token of(Long id, String refreshToken) {
        return Token.builder()
                .id(id)
                .refreshToken(refreshToken)
                .build();
    }
}
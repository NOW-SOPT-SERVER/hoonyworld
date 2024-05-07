package com.sopt.carrotmarket.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sopt.carrotmarket.domain.constant.Location;
import com.sopt.carrotmarket.shared.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Location location;

    public static Member create(String username, String email, String password, Location location) {
        return Member.builder()
                .username(username)
                .email(email)
                .password(password)
                .location(location)
                .build();
    }

    @Builder
    public Member(String username, String email, String password, Location location) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.location = location;
    }
}

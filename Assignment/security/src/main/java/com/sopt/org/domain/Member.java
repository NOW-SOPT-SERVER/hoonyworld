package com.sopt.org.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Part part;

    private int age;

    private String password;


    public static Member create(String name, Part part, int age, String password) {
        return Member.builder()
                .name(name)
                .part(part)
                .age(age)
                .password(password)
                .build();
    }

    @Builder
    public Member(String name, Part part, int age, String password) {
        this.name = name;
        this.part = part;
        this.age = age;
        this.password = password;
    }
}

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


    public static Member create(final String name, final Part part, final int age) {
        return Member.builder()
                .name(name)
                .part(part)
                .age(age)
                .build();
    }

    @Builder
    public Member(final String name, final Part part, final int age) {
        this.name = name;
        this.part = part;
        this.age = age;
    }
}

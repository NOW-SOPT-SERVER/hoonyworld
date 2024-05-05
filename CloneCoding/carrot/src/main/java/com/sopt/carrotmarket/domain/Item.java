package com.sopt.carrotmarket.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Item extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = true)
    private String imageUrl;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemCategory itemCategory;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemTransactionMethod itemTransactionMethod;

    @Column(nullable = false)
    private double price; // 나눔하기 선택시 0으로 설정 가능

    @Column(nullable = false)
    private Boolean isNegotiable = false;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private String preferredLocation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemSoldStatus itemSoldStatus;
}


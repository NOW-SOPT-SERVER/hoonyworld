package com.sopt.carrotmarket.domain;

import com.sopt.carrotmarket.domain.constant.ItemCategory;
import com.sopt.carrotmarket.domain.constant.ItemSoldStatus;
import com.sopt.carrotmarket.domain.constant.ItemTransactionMethod;
import com.sopt.carrotmarket.shared.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Item extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
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

    public static Item create(Member member, String imageUrl, String title, ItemCategory itemCategory,
                              ItemTransactionMethod itemTransactionMethod, double price, Boolean isNegotiable,
                              String description, String preferredLocation, ItemSoldStatus itemSoldStatus) {
        return Item.builder()
                .member(member)
                .imageUrl(imageUrl)
                .title(title)
                .itemCategory(itemCategory)
                .itemTransactionMethod(itemTransactionMethod)
                .price(price)
                .isNegotiable(isNegotiable)
                .description(description)
                .preferredLocation(preferredLocation)
                .itemSoldStatus(itemSoldStatus)
                .build();
    }

    @Builder
    public Item(Member member, String imageUrl, String title, ItemCategory itemCategory,
                ItemTransactionMethod itemTransactionMethod, double price, Boolean isNegotiable,
                String description, String preferredLocation, ItemSoldStatus itemSoldStatus) {
        this.member = member;
        this.imageUrl = imageUrl;
        this.title = title;
        this.itemCategory = itemCategory;
        this.itemTransactionMethod = itemTransactionMethod;
        this.price = price;
        this.isNegotiable = isNegotiable;
        this.description = description;
        this.preferredLocation = preferredLocation;
        this.itemSoldStatus = itemSoldStatus;
    }
}


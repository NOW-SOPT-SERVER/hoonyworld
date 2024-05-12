package com.sopt.carrotmarket.domain;

import com.sopt.carrotmarket.domain.constant.ItemCategory;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class ProductDetails {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemCategory itemCategory;

    public static ProductDetails create(String title, String description, ItemCategory itemCategory) {
        return ProductDetails.builder()
                .title(title)
                .description(description)
                .itemCategory(itemCategory)
                .build();
    }

    @Builder
    public ProductDetails(String title, String description, ItemCategory itemCategory) {
        this.title = title;
        this.description = description;
        this.itemCategory = itemCategory;
    }
}

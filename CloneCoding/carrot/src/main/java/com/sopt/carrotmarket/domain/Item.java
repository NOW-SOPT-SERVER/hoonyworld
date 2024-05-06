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

    @Embedded
    private ProductDetails productDetails;

    @Embedded
    private TransactionDetails transactionDetails;


    @Column(nullable = false)
    private String preferredLocation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemSoldStatus itemSoldStatus;

    public static Item create(Member member, String imageUrl, ProductDetails productDetails,
                              TransactionDetails transactionDetails, String preferredLocation,
                              ItemSoldStatus itemSoldStatus) {
        return Item.builder()
                .member(member)
                .imageUrl(imageUrl)
                .productDetails(productDetails)
                .transactionDetails(transactionDetails)
                .preferredLocation(preferredLocation)
                .itemSoldStatus(itemSoldStatus)
                .build();
    }

    @Builder
    public Item(Member member, String imageUrl, ProductDetails productDetails,
                TransactionDetails transactionDetails, String preferredLocation,
                ItemSoldStatus itemSoldStatus) {
        this.member = member;
        this.imageUrl = imageUrl;
        this.productDetails = productDetails;
        this.transactionDetails = transactionDetails;
        this.preferredLocation = preferredLocation;
        this.itemSoldStatus = itemSoldStatus;
    }
}


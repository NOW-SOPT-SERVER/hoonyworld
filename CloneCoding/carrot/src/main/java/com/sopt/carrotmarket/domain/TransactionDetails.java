package com.sopt.carrotmarket.domain;

import com.sopt.carrotmarket.domain.constant.ItemTransactionMethod;
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
public class TransactionDetails {

    @Column(nullable = false)
    private double price; // 추후 나눔하기 선택시 0으로 설정 가능

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemTransactionMethod itemTransactionMethod;

    @Column(nullable = false)
    private boolean isNegotiable;

    public static TransactionDetails create(double price, ItemTransactionMethod transactionMethod, boolean isNegotiable) {
        return new TransactionDetails(price, transactionMethod, isNegotiable);
    }

    @Builder
    public TransactionDetails(double price, ItemTransactionMethod itemTransactionMethod, boolean isNegotiable) {
        this.price = price;
        this.itemTransactionMethod = itemTransactionMethod;
        this.isNegotiable = isNegotiable;
    }
}

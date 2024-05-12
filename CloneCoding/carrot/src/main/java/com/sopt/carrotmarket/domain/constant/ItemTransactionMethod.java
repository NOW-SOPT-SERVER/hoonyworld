package com.sopt.carrotmarket.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ItemTransactionMethod {
    SALE("판매하기"),
    GIVEAWAY("나눔하기");

    private final String transactionMethod;
}


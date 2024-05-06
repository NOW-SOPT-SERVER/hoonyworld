package com.sopt.carrotmarket.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ItemSoldStatus {
    FOR_SALE("판매중"),
    SOLD_OUT("판매완료"),
    HIDDEN("숨김");

    private final String soldStatus;
}


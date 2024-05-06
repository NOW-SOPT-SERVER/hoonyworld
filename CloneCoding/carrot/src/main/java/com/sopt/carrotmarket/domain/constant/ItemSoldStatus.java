package com.sopt.carrotmarket.domain.constant;

public enum ItemSoldStatus {
    FOR_SALE("판매중"),
    SOLD_OUT("판매완료"),
    HIDDEN("숨김");

    private final String soldStatus;

    ItemSoldStatus(String soldStatus) {
        this.soldStatus = soldStatus;
    }

    public String getSoldStatus() {
        return this.soldStatus;
    }
}


package com.sopt.carrotmarket.domain;

public enum ItemSoldStatus {
    FOR_SALE("판매중"),
    SOLD_OUT("판매완료"),
    HIDDEN("숨김");

    private final String status;

    ItemSoldStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}


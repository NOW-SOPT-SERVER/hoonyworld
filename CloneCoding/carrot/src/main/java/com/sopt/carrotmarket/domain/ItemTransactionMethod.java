package com.sopt.carrotmarket.domain;

public enum ItemTransactionMethod {
    SALE("판매하기"),
    GIVEAWAY("나눔하기");

    private final String transactionMethod;

    ItemTransactionMethod(String transactionMethod) {
        this.transactionMethod = transactionMethod;
    }

    public String getTransactionMethod() {
        return this.transactionMethod;
    }
}


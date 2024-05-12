package com.sopt.carrotmarket.service.dto;

import com.sopt.carrotmarket.domain.ProductDetails;
import com.sopt.carrotmarket.domain.TransactionDetails;
import com.sopt.carrotmarket.domain.constant.ItemSoldStatus;

public record ItemCreateRequest(
        String imageUrl,
        ProductDetails productDetails,
        TransactionDetails transactionDetails,
        String preferredLocation,
        ItemSoldStatus itemSoldStatus
) {
}
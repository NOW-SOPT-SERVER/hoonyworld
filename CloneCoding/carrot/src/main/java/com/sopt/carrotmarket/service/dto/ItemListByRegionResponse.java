package com.sopt.carrotmarket.service.dto;

import com.sopt.carrotmarket.domain.Item;
import com.sopt.carrotmarket.domain.constant.ItemCategory;
import com.sopt.carrotmarket.domain.constant.ItemSoldStatus;
import com.sopt.carrotmarket.domain.constant.ItemTransactionMethod;
import com.sopt.carrotmarket.domain.constant.Location;

import java.time.LocalDateTime;

public record ItemListByRegionResponse(
        Long memberId,
        Location location,
        String imageUrl,
        String title,
        double price,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        ItemCategory itemCategory,
        ItemSoldStatus itemSoldStatus,
        ItemTransactionMethod itemTransactionMethod
) {
    public static ItemListByRegionResponse from(Item item) {
        return new ItemListByRegionResponse(
                item.getMember().getId(),
                item.getMember().getLocation(),
                item.getImageUrl(),
                item.getProductDetails().getTitle(),
                item.getTransactionDetails().getPrice(),
                item.getCreatedAt(),
                item.getUpdatedAt(),
                item.getProductDetails().getItemCategory(),
                item.getItemSoldStatus(),
                item.getTransactionDetails().getItemTransactionMethod()
        );
    }

}

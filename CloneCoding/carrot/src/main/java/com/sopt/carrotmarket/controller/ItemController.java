package com.sopt.carrotmarket.controller;

import com.sopt.carrotmarket.common.dto.SuccessStatusResponse;
import com.sopt.carrotmarket.common.dto.message.SuccessMessage;
import com.sopt.carrotmarket.service.ItemService;
import com.sopt.carrotmarket.service.dto.ItemCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item")
    public ResponseEntity<SuccessStatusResponse> createItem(
            @RequestHeader Long memberId,
            @RequestBody ItemCreateRequest itemCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                "Location",
                itemService.createItem(memberId, itemCreateRequest))
                .body(SuccessStatusResponse.from(SuccessMessage.ITEM_REGISTER_SUCCESS));
    }
}

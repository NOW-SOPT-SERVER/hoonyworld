package com.sopt.carrotmarket.controller;

import com.sopt.carrotmarket.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/like")
    @ResponseStatus(HttpStatus.CREATED)
    public void addLike(
            @RequestHeader Long memberId,
            @RequestHeader Long itemId) {
        likeService.addLike(memberId, itemId);
    }
}

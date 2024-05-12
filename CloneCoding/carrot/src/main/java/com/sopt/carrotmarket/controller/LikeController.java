package com.sopt.carrotmarket.controller;

import com.sopt.carrotmarket.common.dto.SuccessStatusResponse;
import com.sopt.carrotmarket.common.dto.message.SuccessMessage;
import com.sopt.carrotmarket.service.LikeService;
import com.sopt.carrotmarket.service.dto.LikeCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/like")
    public ResponseEntity<SuccessStatusResponse> addLike(
            @RequestBody LikeCreateRequest likeCreateRequest) {
        String locationHeader = likeService.addLike(likeCreateRequest);
        if (locationHeader != null) {
            // 좋아요 추가 성공
            return ResponseEntity.status(HttpStatus.CREATED)
                    .header("Location", locationHeader)
                    .body(SuccessStatusResponse.from(SuccessMessage.EXTRA_LIKE_BUTTON));
        } else {
            // 좋아요 삭제
            return ResponseEntity.status(HttpStatus.OK)
                    .body(SuccessStatusResponse.from(SuccessMessage.DELETE_LIKE_BUTTON));
        }
    }
}

package com.sopt.carrotmarket.controller;

import com.sopt.carrotmarket.common.dto.SuccessStatusResponse;
import com.sopt.carrotmarket.common.dto.message.SuccessMessage;
import com.sopt.carrotmarket.service.MemberService;
import com.sopt.carrotmarket.service.dto.MemberCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<SuccessStatusResponse> createMember(
            @RequestBody MemberCreateRequest memberCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                "Location", memberService.createMember(memberCreateRequest))
                .body(SuccessStatusResponse.from(SuccessMessage.MEMBER_CREATE_SUCCESS));
    }
}
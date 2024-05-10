package com.sopt.org.controller;

import com.sopt.org.service.MemberService;
import com.sopt.org.service.dto.MemberCreateDto;
import com.sopt.org.service.dto.MemberFindDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<Void> createMember(
            @RequestBody MemberCreateDto memberCreateDto) {
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreateDto)))
                .build();
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<MemberFindDto> getMemberById(
            @PathVariable("memberId") Long memberId
    ) {
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @DeleteMapping("/member/{memberId}")
    public ResponseEntity<Void> deleteMemberById(
            @PathVariable("memberId") Long memberId
    ) {
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberFindDto>> getAllMembers() {
        return ResponseEntity.ok(memberService.findAllMembers());
    }
}

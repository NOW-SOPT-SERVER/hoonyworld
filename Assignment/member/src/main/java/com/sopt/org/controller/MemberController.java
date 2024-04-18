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
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity createMember(@RequestBody MemberCreateDto memberCreateDto) {
        return ResponseEntity.created(URI.create(memberService.createMember(memberCreateDto))).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberFindDto> findMemberById(
            @PathVariable("memberId") Long memberId
    ) {
        return ResponseEntity.ok(memberService.findMemberById(memberId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMemberById(
            @PathVariable("memberId") Long memberId
    ) {
        memberService.deleteMemberById(memberId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberFindDto>> findAllMembers() {
        return ResponseEntity.ok(memberService.findAllMembers());
    }
}

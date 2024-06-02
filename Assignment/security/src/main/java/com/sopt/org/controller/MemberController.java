package com.sopt.org.controller;

import com.sopt.org.service.MemberService;
import com.sopt.org.service.dto.MemberCreateDto;
import com.sopt.org.service.dto.MemberFindDto;
import com.sopt.org.service.dto.UserJoinResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {
    private final MemberService memberService;

//    @PostMapping("/member")
//    public ResponseEntity<Void> createMember(@RequestBody MemberCreateDto memberCreateDto) {
//        return ResponseEntity.created(URI.create(memberService.createMember(memberCreateDto))).build();
//    }

    @PostMapping("/member")
    public ResponseEntity<UserJoinResponse> postMember(
            @RequestBody MemberCreateDto memberCreateDto
    ) {
        UserJoinResponse userJoinResponse = memberService.createMember(memberCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", userJoinResponse.userId())
                .body(
                        userJoinResponse
                );
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

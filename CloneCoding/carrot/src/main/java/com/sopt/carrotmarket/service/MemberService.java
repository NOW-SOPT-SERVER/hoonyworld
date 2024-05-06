package com.sopt.carrotmarket.service;

import com.sopt.carrotmarket.domain.Member;
import com.sopt.carrotmarket.repository.MemberRepository;
import com.sopt.carrotmarket.service.dto.MemberCreateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private  final MemberRepository memberRepository;

    @Transactional
    public String createMember(MemberCreateRequest memberCreateRequest) {
        Member member = memberRepository.save(Member.create(memberCreateRequest.username(), memberCreateRequest.email(), memberCreateRequest.password(), memberCreateRequest.location()));
        return member.getId().toString();
    }
}

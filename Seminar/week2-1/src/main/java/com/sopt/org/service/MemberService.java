package com.sopt.org.service;

import com.sopt.org.domain.Member;
import com.sopt.org.repository.MemberRepository;
import com.sopt.org.service.dto.MemberCreateDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public String createMember(MemberCreateDto memberCreateDto) {
        Member member = memberRepository.save(Member.create(memberCreateDto.name(), memberCreateDto.part(), memberCreateDto.age()));
        return member.getId().toString();
    }
}

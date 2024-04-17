package com.sopt.org.service;

import com.sopt.org.domain.Member;
import com.sopt.org.repository.MemberRepository;
import com.sopt.org.service.dto.MemberCreateDto;
import com.sopt.org.service.dto.MemberFindDto;
import jakarta.persistence.EntityNotFoundException;
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

    public MemberFindDto findMemberById(
            Long memberId
    ) {
        return MemberFindDto.of(memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
        ));
    }

    @Transactional
    public void deleteMemberById(
            Long memberId
    ) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다."));
        memberRepository.delete(member);
    }
}

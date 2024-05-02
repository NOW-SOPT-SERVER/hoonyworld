package com.sopt.org.service;

import com.sopt.org.domain.Member;
import com.sopt.org.exception.NotFoundException;
import com.sopt.org.common.dto.message.ErrorMessage;
import com.sopt.org.repository.MemberRepository;
import com.sopt.org.service.dto.MemberCreateDto;
import com.sopt.org.service.dto.MemberFindDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

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
        return MemberFindDto.from(memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
        ));
    }

    @Transactional
    public void deleteMemberById(
            Long memberId
    ) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
        );
        memberRepository.delete(member);
    }

    public List<MemberFindDto> findAllMembers() {
        return MemberFindDto.listOf(memberRepository.findAll());
    }

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
        );
    }
}

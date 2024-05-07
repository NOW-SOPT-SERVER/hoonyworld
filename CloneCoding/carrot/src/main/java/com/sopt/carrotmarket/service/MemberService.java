package com.sopt.carrotmarket.service;

import com.sopt.carrotmarket.common.dto.message.ErrorMessage;
import com.sopt.carrotmarket.domain.Member;
import com.sopt.carrotmarket.exception.NotFoundException;
import com.sopt.carrotmarket.repository.MemberRepository;
import com.sopt.carrotmarket.service.dto.MemberCreateRequest;
import com.sopt.carrotmarket.service.dto.MemberFindResponse;
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

    public MemberFindResponse findMemberById(
            long memberId
    ) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
        );
        return MemberFindResponse.from(member);
    }

    public Member findById(long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
        );
    }
}

package com.sopt.carrotmarket.service;

import com.sopt.carrotmarket.domain.Item;
import com.sopt.carrotmarket.domain.Like;
import com.sopt.carrotmarket.domain.Member;
import com.sopt.carrotmarket.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final ItemService itemService;
    private final MemberService memberService;

    public void addLike(Long memberId, Long blogId) {
        Member member = memberService.findById(memberId);
        Item item = itemService.findById(blogId);

        // 이미 좋아요한 경우 좋아요를 해제하고, 아닌 경우 좋아요를 추가.
        if (likeRepository.existsByMemberAndItem(member, item)) {
            likeRepository.deleteByMemberAndItem(member, item);
        } else {
            Like like = new Like(member, item);
            likeRepository.save(like);
        }
    }
}

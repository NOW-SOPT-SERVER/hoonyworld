package com.sopt.carrotmarket.service;

import com.sopt.carrotmarket.domain.Item;
import com.sopt.carrotmarket.domain.Like;
import com.sopt.carrotmarket.domain.Member;
import com.sopt.carrotmarket.repository.LikeRepository;
import com.sopt.carrotmarket.service.dto.LikeCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final ItemService itemService;
    private final MemberService memberService;

    public String addLike(LikeCreateRequest likeCreateRequest) {
        Member member = memberService.findById(likeCreateRequest.memberId());
        Item item = itemService.findById(likeCreateRequest.itemId());

        // 이미 좋아요한 경우 좋아요를 해제하고, 아닌 경우 좋아요를 추가.
        if (likeRepository.existsByMemberAndItem(member, item)) {
            likeRepository.deleteByMemberAndItem(member, item);
            return null;
        } else {
            Like like = new Like(member, item);
            likeRepository.save(like);
            return item.getId().toString();
        }
    }
}

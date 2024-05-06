package com.sopt.carrotmarket.service;

import com.sopt.carrotmarket.domain.Item;
import com.sopt.carrotmarket.domain.Member;
import com.sopt.carrotmarket.repository.ItemRepository;
import com.sopt.carrotmarket.service.dto.ItemCreateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final MemberService memberService;
    private final ItemRepository itemRepository;

    @Transactional
    public String createItem(Long memberId, ItemCreateRequest itemCreateRequest) {
        Member member = memberService.findById(memberId);
        Item item = itemRepository.save(Item.create(member, itemCreateRequest));
        return item.getId().toString();
    }
}
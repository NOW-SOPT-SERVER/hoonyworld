package com.sopt.carrotmarket.service;

import com.sopt.carrotmarket.common.dto.message.ErrorMessage;
import com.sopt.carrotmarket.domain.Item;
import com.sopt.carrotmarket.domain.Member;
import com.sopt.carrotmarket.domain.constant.Location;
import com.sopt.carrotmarket.exception.NotFoundException;
import com.sopt.carrotmarket.repository.ItemRepository;
import com.sopt.carrotmarket.service.dto.ItemCreateRequest;
import com.sopt.carrotmarket.service.dto.ItemListByRegionResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ItemListByRegionResponse> getItemsByLocation(Location location) {
        List<Item> items = itemRepository.findByMemberLocation(location);
        return items.stream()
                .map(ItemListByRegionResponse::from)
                .toList();
    }

    public Item findById(Long itemId) {
        return itemRepository.findById(itemId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.ITEM_NOT_FOUND_BY_ID_EXCEPTION)
        );
    }
}
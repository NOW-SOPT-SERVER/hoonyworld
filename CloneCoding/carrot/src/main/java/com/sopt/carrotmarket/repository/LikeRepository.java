package com.sopt.carrotmarket.repository;

import com.sopt.carrotmarket.domain.Item;
import com.sopt.carrotmarket.domain.Like;
import com.sopt.carrotmarket.domain.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByMemberAndItem(Member member, Item item);

    @Transactional
    void deleteByMemberAndItem(Member member, Item item);
}

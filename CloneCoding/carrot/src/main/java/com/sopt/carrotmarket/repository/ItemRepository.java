package com.sopt.carrotmarket.repository;

import com.sopt.carrotmarket.domain.Item;
import com.sopt.carrotmarket.domain.constant.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select i from Item i where i.member.location = :location")
    List<Item> findByMemberLocation(Location location);
}

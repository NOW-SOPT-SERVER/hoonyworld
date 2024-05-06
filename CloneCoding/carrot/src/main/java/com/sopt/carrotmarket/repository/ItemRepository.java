package com.sopt.carrotmarket.repository;

import com.sopt.carrotmarket.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}

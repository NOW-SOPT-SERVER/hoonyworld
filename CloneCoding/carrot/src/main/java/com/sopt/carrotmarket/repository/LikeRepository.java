package com.sopt.carrotmarket.repository;

import com.sopt.carrotmarket.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}

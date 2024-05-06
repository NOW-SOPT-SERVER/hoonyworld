package com.sopt.carrotmarket.repository;

import com.sopt.carrotmarket.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

package com.teamfresh.vossystem.repository;

import com.teamfresh.vossystem.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}

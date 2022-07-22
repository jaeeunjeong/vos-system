package com.teamfresh.vossystem.repository.claim;

import com.teamfresh.vossystem.entity.claim.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
}

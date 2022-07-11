package com.teamfresh.vossystem.repository;

import com.teamfresh.vossystem.entity.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PenaltyRepository extends JpaRepository<Penalty, Long> {
    @Override
    Optional<Penalty> findById(Long id);
}
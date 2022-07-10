package com.teamfresh.vossystem.repository;

import com.teamfresh.vossystem.entity.Voc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VocRepository extends JpaRepository<Voc, Long> {
    Optional<Voc> findByUserId(Long userId);
}

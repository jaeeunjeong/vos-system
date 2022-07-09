package com.teamfresh.vossystem.repository;

import com.teamfresh.vossystem.entity.VOC;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VOCRepository extends JpaRepository<VOC, Long> {
    Optional<VOC> findByUserId(Long userId);
}

package com.teamfresh.vossystem.repository.voc;

import com.teamfresh.vossystem.entity.voc.Voc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VocRepository extends JpaRepository<Voc, Long> {
    Optional<Voc> findByUserId(Long userId);
}

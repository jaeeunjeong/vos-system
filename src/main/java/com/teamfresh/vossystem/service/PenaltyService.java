package com.teamfresh.vossystem.service;

import com.teamfresh.vossystem.dto.PenaltyDto;
import com.teamfresh.vossystem.entity.Penalty;
import com.teamfresh.vossystem.exception.PenaltyNotFoundException;
import com.teamfresh.vossystem.repository.PenaltyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PenaltyService {

    private final PenaltyRepository penaltyRepository;

    public void insertPenalty(PenaltyDto dto) {
        penaltyRepository.save(new Penalty(dto.getClaimId(), dto.getPenaltyPrice()));
    }

    public void updateReparationForDriver(Long penaltyId) {
        Penalty penalty = penaltyRepository.findById(penaltyId).orElseThrow(PenaltyNotFoundException::new);
        penalty.updateDriverCheck();
    }
}

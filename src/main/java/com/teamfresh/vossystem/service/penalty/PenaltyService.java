package com.teamfresh.vossystem.service.penalty;

import com.teamfresh.vossystem.dto.penalty.PenaltyDto;
import com.teamfresh.vossystem.entity.penalty.Penalty;
import com.teamfresh.vossystem.exception.PenaltyNotFoundException;
import com.teamfresh.vossystem.repository.penalty.PenaltyRepository;
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

package com.teamfresh.vossystem.controller;

import com.teamfresh.vossystem.dto.PenaltyCheckRequestDto;
import com.teamfresh.vossystem.service.PenaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PenaltyController {

    private final PenaltyService penaltyService;

    @PutMapping
    public void updatePenaltyCheckForDriver(PenaltyCheckRequestDto dto) {
        penaltyService.updateReparationForDriver(dto);
    }
}

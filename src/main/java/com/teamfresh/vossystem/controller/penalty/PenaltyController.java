package com.teamfresh.vossystem.controller.penalty;

import com.teamfresh.vossystem.service.penalty.PenaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PenaltyController {

    private final PenaltyService penaltyService;

    @PutMapping("/api/penalty/{id}")
    public void updatePenaltyCheckForDriver(@PathVariable Long id) {
        penaltyService.updateReparationForDriver(id);
    }
}

package com.teamfresh.vossystem.controller.claim;

import com.teamfresh.vossystem.Member;
import com.teamfresh.vossystem.dto.claim.ClaimCreateRequestDto;
import com.teamfresh.vossystem.dto.penalty.PenaltyDto;
import com.teamfresh.vossystem.dto.response.Response;
import com.teamfresh.vossystem.entity.claim.Claim;
import com.teamfresh.vossystem.service.claim.ClaimService;
import com.teamfresh.vossystem.service.penalty.PenaltyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ClaimController {

    private final ClaimService claimService;
    private final PenaltyService penaltyService;

    @GetMapping("/api/claimAll")
    public Response readClaimList() {
        return Response.success(claimService.findAllClaimList());
    }

    @PostMapping("/api/claim")
    public Response addClaim(ClaimCreateRequestDto dto) {
        Claim claim = claimService.insertClaim(dto);

        if (dto.getReasonType() == Member.COMPANY) {

            // 배상 시스템 바로 적용

        } else if (dto.getReasonType() == Member.DRIVER) {
            PenaltyDto penaltyRequestDto = new PenaltyDto(claim.getId(), dto.getUserId(), dto.getPenaltyPrice(), Member.DRIVER);
            penaltyService.insertPenalty(penaltyRequestDto);
        }

        return Response.success();
    }
}

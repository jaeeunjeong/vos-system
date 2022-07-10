package com.teamfresh.vossystem.controller;

import com.teamfresh.vossystem.dto.ClaimCreateRequestDto;
import com.teamfresh.vossystem.dto.response.Response;
import com.teamfresh.vossystem.service.ClaimService;
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

    @GetMapping("/api/claimAll")
    public Response readClaimList(){
        return Response.success(claimService.findAllClaimList());
    }

    @PostMapping("/api/claim")
    public Response addClaim(ClaimCreateRequestDto dto) {
        claimService.insertClaim(dto);
        return Response.success();
    }
}

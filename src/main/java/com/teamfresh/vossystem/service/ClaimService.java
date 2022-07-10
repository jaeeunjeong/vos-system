package com.teamfresh.vossystem.service;

import com.teamfresh.vossystem.dto.ClaimCreateRequestDto;
import com.teamfresh.vossystem.dto.ClaimListResponseDto;
import com.teamfresh.vossystem.entity.Claim;
import com.teamfresh.vossystem.exception.VocNotFoundException;
import com.teamfresh.vossystem.repository.ClaimRepository;
import com.teamfresh.vossystem.repository.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClaimService {

    private final ClaimRepository claimRepository;
    private final VocRepository vocRepository;

    public List<ClaimListResponseDto> findAllClaimList() {
        List<Claim> claimList = claimRepository.findAll();
        return ClaimListResponseDto.toDtoList(claimList);
    }

    @Transactional
    public void insertClaim(ClaimCreateRequestDto req) {
        claimRepository.save(ClaimCreateRequestDto.toEntity(req));
    }
}

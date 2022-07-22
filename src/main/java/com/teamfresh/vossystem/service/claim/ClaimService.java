package com.teamfresh.vossystem.service.claim;

import com.teamfresh.vossystem.dto.claim.ClaimCreateRequestDto;
import com.teamfresh.vossystem.dto.claim.ClaimListResponseDto;
import com.teamfresh.vossystem.entity.claim.Claim;
import com.teamfresh.vossystem.repository.claim.ClaimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClaimService {

    private final ClaimRepository claimRepository;

    public List<ClaimListResponseDto> findAllClaimList() {
        List<Claim> claimList = claimRepository.findAll();
        return ClaimListResponseDto.toDtoList(claimList);
    }

    @Transactional
    public Claim insertClaim(ClaimCreateRequestDto req) {
        return claimRepository.save(ClaimCreateRequestDto.toEntity(req));
    }
}

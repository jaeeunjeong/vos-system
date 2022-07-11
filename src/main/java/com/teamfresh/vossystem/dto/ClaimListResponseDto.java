package com.teamfresh.vossystem.dto;

import com.teamfresh.vossystem.entity.Claim;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClaimListResponseDto {

    private Long vocId;
    private Long price;

    public static List<ClaimListResponseDto> toDtoList(List<Claim> claimList) {
        List<ClaimListResponseDto> result = new ArrayList<ClaimListResponseDto>();
        for (Claim claim : claimList) {
            ClaimListResponseDto dto = new ClaimListResponseDto();
            dto.setVocId(claim.getVocId());
            dto.setPrice(claim.getPrice());
            result.add(dto);
        }
        return result;
    }
}

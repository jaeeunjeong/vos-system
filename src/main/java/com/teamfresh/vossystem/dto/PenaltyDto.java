package com.teamfresh.vossystem.dto;

import com.teamfresh.vossystem.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PenaltyDto {
    private Long claimId;
    private Long userId;
    private Long penaltyPrice;
    private Member memberType;
}

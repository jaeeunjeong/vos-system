package com.teamfresh.vossystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PenaltyCheckRequestDto {
    private Long userId;
    private Long penaltyPrice;
    private Long penaltyId;
}

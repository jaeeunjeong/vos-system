package com.teamfresh.vossystem.dto;

import com.teamfresh.vossystem.Member;
import com.teamfresh.vossystem.entity.Claim;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClaimCreateRequestDto {
    private Long vocId; //  귀책 당사자 고유 id

    private Long userId;

    private Long penaltyPrice;

    private Member reasonType; // 귀책 당사자 타입

    public static Claim toEntity(ClaimCreateRequestDto dto) {
        return new Claim(dto.getVocId(), dto.getUserId(), dto.penaltyPrice, dto.getReasonType());
    }
}

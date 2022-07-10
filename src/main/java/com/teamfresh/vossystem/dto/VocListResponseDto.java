package com.teamfresh.vossystem.dto;

import com.teamfresh.vossystem.entity.Voc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VocListResponseDto {
    private Long userId;
    private String VocReason;
    private Long penaltyId;
    private boolean driverCheck;
    private boolean appeal;
    private Long claimDetail;

    public static List<VocListResponseDto> toDtoList(List<Voc> vocList){
        List<VocListResponseDto> result = new ArrayList<VocListResponseDto>();
        for(Voc voc : vocList){
            VocListResponseDto dto = new VocListResponseDto();
            dto.setUserId(voc.getUserId());
            dto.setVocReason(voc.getVocReason());
            dto.setPenaltyId(voc.getPenaltyId());
            dto.setDriverCheck(voc.isDriverCheck());
            dto.setAppeal(voc.isAppeal());
            dto.setClaimDetail(voc.getClaimDetailId());
        }
        return result;
    }
}

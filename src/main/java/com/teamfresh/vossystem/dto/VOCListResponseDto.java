package com.teamfresh.vossystem.dto;

import com.teamfresh.vossystem.entity.VOC;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VOCListResponseDto {
    private Long userId;
    private String VocReason;
    private String penaltyContent;
    private boolean driverCheck;
    private boolean appeal;
    private Long claimDetail;

    public static VOCListResponseDto toDtoList(List<VOC> vocList){
        return null;
    }
}

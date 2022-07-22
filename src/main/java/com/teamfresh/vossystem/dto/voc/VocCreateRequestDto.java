package com.teamfresh.vossystem.dto.voc;

import com.teamfresh.vossystem.Member;
import com.teamfresh.vossystem.entity.voc.Voc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VocCreateRequestDto {
    private Long id;

    private Member reasonType; // 귀책 당사자 타입

    private Long userId; //  귀책 당사자 고유 id

    private String vocReason;

    private boolean driverCheck;

    private boolean appeal;

    public static Voc toEntity(VocCreateRequestDto req) {
        return new Voc(req.getReasonType(), req.getUserId(), req.getVocReason(), false, false);
    }
}

package com.teamfresh.vossystem.entity;

import com.teamfresh.vossystem.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VOC {
    @Id
    @GeneratedValue
    @Column(name = "voice_id")
    private Long id;

    private Member reasonType; // 귀책 당사자 타입

    private Long userId; //  귀책 당사자 고유 id

    private String claimContent; // 간단한 귀책
    private String penaltyContent; // 패널티 내용

    private String VocReason;

    private boolean driverCheck;

    private boolean appeal;

    private Long claimDetailId; // 귀책 내용을 조회하기 위함.

    public VOC(Member reasonType, Long userId, String claimContent, String penaltyContent, String vocReason, boolean driverCheck, boolean appeal, Long claimDetailId) {
        this.reasonType = reasonType;
        this.userId = userId;
        this.claimContent = claimContent;
        this.penaltyContent = penaltyContent;
        this.VocReason = vocReason;
        this.driverCheck = driverCheck;
        this.appeal = appeal;
        this.claimDetailId = claimDetailId;
    }
}
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
public class Voc {

    @Id
    @GeneratedValue
    @Column(name = "voc_id")
    private Long id;

    private Member reasonType; // 귀책 당사자 타입

    private Long userId; //  귀책 당사자 고유 id

    @Column(name = "claim_content", nullable = false, length = 30, unique = true)
    private String claimContent; // 간단한 귀책

    @Column(name = "penalty_content", nullable = false, length = 30, unique = true)
    private String penaltyContent; // 패널티 내용

    @Column(name = "voc_reason",  nullable = false, length = 30, unique = true)
    private String vocReason;

    @Column(name = "driver_check")
    private boolean driverCheck;

    private boolean appeal;

    @Column(name = "claim_detail_id")
    private Long claimDetailId; // 귀책 내용을 조회하기 위함.

    public Voc(Member reasonType, Long userId, String claimContent, String penaltyContent, String vocReason, boolean driverCheck, boolean appeal, Long claimDetailId) {
        this.reasonType = reasonType;
        this.userId = userId;
        this.claimContent = claimContent;
        this.penaltyContent = penaltyContent;
        this.vocReason = vocReason;
        this.driverCheck = driverCheck;
        this.appeal = appeal;
        this.claimDetailId = claimDetailId;
    }
}
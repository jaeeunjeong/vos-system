package com.teamfresh.vossystem.entity;

import com.teamfresh.vossystem.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Voc {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "voc_id")
    private Long id;

    @Column(name = "reason_type")
    private Member reasonType; // 귀책 당사자 타입

    @Column(name = "user_id")
    private Long userId; //  귀책 당사자 고유 id

    @Column(name = "voc_reason")
    private String vocReason;

    @Column(name = "driver_check")
    private boolean driverCheck;

    private boolean appeal;

    public Voc(Member reasonType, Long userId, String vocReason, boolean driverCheck, boolean appeal) {
        this.reasonType = reasonType;
        this.userId = userId;
        this.vocReason = vocReason;
        this.driverCheck = driverCheck;
        this.appeal = appeal;
    }
}
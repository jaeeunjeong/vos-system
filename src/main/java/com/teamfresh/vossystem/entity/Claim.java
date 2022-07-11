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
public class Claim {

    @Id
    @GeneratedValue
    @Column(name = "claim_id")
    private Long id;

    @Column(name = "voc_id")
    private Long vocId;

    @Column(name = "user_id")
    private Long userId;

    private Long price;

    @Column(name = "reason_type")
    private Member reasonType;

    public Claim(Long vocId, Long userId, Long price, Member reasonType) {
        this.vocId = vocId;
        this.userId = userId;
        this.price = price;
        this.reasonType = reasonType;
    }
}

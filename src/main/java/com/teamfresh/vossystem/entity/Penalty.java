package com.teamfresh.vossystem.entity;

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
public class Penalty {

    @Id
    @GeneratedValue
    @Column(name = "penalty_id")
    private Long id;

    @Column(name = "claim_id")
    private Long claimId;

    @Column(name = "penaltyPrice")
    private Long penaltyPrice;

    @Column(name = "driver_check")
    private boolean driverCheck;

    @Column(name = "reparation_check")
    private boolean reparationCheck;

    public Penalty(Long claimId, Long penaltyPrice) {
        this.claimId = claimId;
        this.penaltyPrice = penaltyPrice;
    }

    public void updateDriverCheck() {
        this.driverCheck = true;
    }
}

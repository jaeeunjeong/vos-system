package com.teamfresh.vossystem.entity.penalty;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Penalty {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "penalty_id")
    private Long id;

    @Column(name = "claim_id")
    private Long claimId;

    @Column(name = "penalty_price")
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

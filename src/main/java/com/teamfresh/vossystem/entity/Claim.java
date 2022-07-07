package com.teamfresh.vossystem.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Claim {

    @Id
    @GeneratedValue
    private Long id;

    private Long vocId;

    private Long vocPrice;

    public Claim(Long vocId, Long vocPrice) {
        this.vocId = vocId;
        this.vocPrice = vocPrice;
    }
}

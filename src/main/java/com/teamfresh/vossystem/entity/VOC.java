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
public class VOC {
    @Id
    @GeneratedValue
    @Column(name = "voice_seq")
    private Long id;

    private Long userId;

    private String attributable;

    private String penalty;

    private boolean driverCheck;

    private boolean objection;

    public VOC(Long userId, String attributable, String penalty, boolean driverCheck, boolean objection) {
        this.userId = userId;
        this.attributable = attributable;
        this.penalty = penalty;
        this.driverCheck = driverCheck;
        this.objection = objection;
    }
}

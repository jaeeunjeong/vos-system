package com.teamfresh.vossystem.repository.claim;

import com.teamfresh.vossystem.Member;
import com.teamfresh.vossystem.entity.claim.Claim;
import com.teamfresh.vossystem.repository.claim.ClaimRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ClaimRepositoryTest {
    @PersistenceContext
    EntityManager em;
    @Autowired
    ClaimRepository claimRepository;

    @DisplayName("클레임이 들어왔을 때 : 배상 정보 등록")
    @Test
    void test1() {
        // given
        Claim claim = new Claim(1L, 1L, 1000L, Member.COMPANY);

        // when
        Claim resultClaim = claimRepository.save(claim);
        clear();

        // then
        assertThat(resultClaim.getId()).isEqualTo(claim.getId());
        assertThat(resultClaim.getUserId()).isEqualTo(claim.getUserId());
    }

    @DisplayName("배상 목록 조회하기.")
    @Test
    void test2() {
        // given
        List<Claim> claims =  Arrays.asList(1L, 2L, 3L).stream().map((n) -> createClaimWithUserId(n, n)).collect(Collectors.toList());
        claimRepository.saveAll(claims);
        clear();

        // when
        List<Claim> result = claimRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(claims.size());
    }

    Claim createClaimWithUserId(Long vocId, Long userId) {
        return new Claim(vocId, userId,1000L, Member.DRIVER);
    }

    void clear() {
        em.flush();
        em.clear();
    }
}

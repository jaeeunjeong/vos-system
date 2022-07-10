package com.teamfresh.vossystem.repository;

import com.teamfresh.vossystem.Member;
import com.teamfresh.vossystem.entity.Voc;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class VocRepositoryTest {

    @PersistenceContext
    EntityManager em;
    @Autowired
    VocRepository vocRepository;

    @DisplayName("등록하기")
    @Test
    void test1() {
        // given, when
        Voc voc = createVOC();
        Long userId = voc.getUserId();
        Voc resultVoc = vocRepository.save(voc);
        clear();

        Optional<Voc> foundVoc = vocRepository.findByUserId(userId);

        // then
        assertThat(foundVoc.orElseThrow(null).getUserId()).isEqualTo(userId);
    }

    @DisplayName("VOC 목록 조회하기.")
    @Test
    void test2() {
        // given
        List<Voc> vocs = Arrays.asList(1L, 2L, 3L).stream().map(n -> createVOCWithUserId(n)).collect(Collectors.toList());
        String penalty = "오발송";
        vocRepository.saveAll(vocs);
        clear();

        // when
        List<Voc> foundVocs = vocRepository.findAll();

        // then
        assertThat(vocs.size()).isEqualTo(foundVocs.size());
    }

    void clear() {
        em.flush();
        em.clear();
    }

    Voc createVOC() {
        return new Voc(Member.DRIVER, 1L, "오배송", 1L, "오배송", false, false, 1L);
    }

    Voc createVOCWithUserId(Long id) {
        return new Voc(Member.DRIVER, id, "오배송", 1L, "오배송", false, false, 1L);
    }
}

package com.teamfresh.vossystem.repository;

import com.teamfresh.vossystem.Member;
import com.teamfresh.vossystem.entity.VOC;
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
public class VOCRepositoryTest {

    @PersistenceContext
    EntityManager em;
    @Autowired
    VOCRepository vocRepository;

    @DisplayName("등록하기")
    @Test
    void test1() {
        // given, when
        VOC voc = createVOC();
        Long userId = voc.getUserId();
        VOC resultVoc = vocRepository.save(voc);
        clear();

        Optional<VOC> foundVoc = vocRepository.findByUserId(userId);

        // then
        assertThat(foundVoc.orElseThrow(null).getUserId()).isEqualTo(userId);
    }

    @DisplayName("VOC 목록 조회하기.")
    @Test
    void test2() {
        // given
        List<VOC> vocs = Arrays.asList(1L, 2L, 3L).stream().map(n -> createVOCWithUserId(n)).collect(Collectors.toList());
        String penalty = "오발송";
        vocRepository.saveAll(vocs);
        clear();

        // when
        List<VOC> foundVocs = vocRepository.findAll();
        // then

        assertThat(vocs.size()).isEqualTo(foundVocs.size());
    }

    void clear() {
        em.flush();
        em.clear();

    }

    VOC createVOC() {
        return new VOC(Member.DRIVER, 1L, "오배송", "오배송", "오배송", false, false, 1L);
    }

    VOC createVOCWithUserId(Long id) {
        return new VOC(Member.DRIVER, id, "오배송", "오배송", "오배송", false, false, 1L);
    }
}

package com.teamfresh.vossystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamfresh.vossystem.Member;
import com.teamfresh.vossystem.dto.VocCreateRequestDto;
import com.teamfresh.vossystem.entity.Voc;
import com.teamfresh.vossystem.service.VocService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class VocControllerTest {

    @InjectMocks
    VocController vocController;
    @Mock
    VocService vocService;
    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(vocController).build();
    }

    @Test
    void readVocListTest() throws Exception {
        // given
        List<Voc> vocs = Arrays.asList(1L, 2L, 3L).stream().map(n -> createVOCWithUserId(n)).collect(Collectors.toList());

        // when, then
        mockMvc.perform(
                get("/api/vocAll"))
                .andExpect(status().isOk());

        verify(vocService).findAllVocList();
    }

    @Test
    void createVocTest() throws Exception {
        // given
        VocCreateRequestDto req = new VocCreateRequestDto(1L, Member.DRIVER, 1L, "오배송", false, false);

        // when, then
        mockMvc.perform(
                post("/api/voc")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk());

        verify(vocService).insertVOC(refEq(req));
    }

    Voc createVOCWithUserId(Long id) {
        return new Voc(Member.DRIVER, id, "오배송", false, false);
    }
}
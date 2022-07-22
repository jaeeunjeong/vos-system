package com.teamfresh.vossystem.controller.claim;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamfresh.vossystem.Member;
import com.teamfresh.vossystem.controller.claim.ClaimController;
import com.teamfresh.vossystem.dto.claim.ClaimCreateRequestDto;
import com.teamfresh.vossystem.entity.claim.Claim;
import com.teamfresh.vossystem.service.claim.ClaimService;
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
class ClaimControllerTest {

    @InjectMocks
    ClaimController claimController;
    @Mock
    ClaimService claimService;
    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(claimController).build();
    }

    @Test
    void readVocListTest() throws Exception {
        // given
        List<Claim> claims = Arrays.asList(1L, 2L, 3L).stream().map(n -> createClaimWithUserId(n, n)).collect(Collectors.toList());

        // when, then
        mockMvc.perform(
                get("/api/claimAll"))
                .andExpect(status().isOk());

        verify(claimService).findAllClaimList();
    }

    @Test
    void createVocTest() throws Exception {
        // given
        ClaimCreateRequestDto req = new ClaimCreateRequestDto(1L, 1L, 1000L, Member.DRIVER);

        // when, then
        mockMvc.perform(
                post("/api/claim")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isCreated());

        verify(claimService).insertClaim(refEq(req));
    }

    Claim createClaimWithUserId(Long vocId, Long userId) {
        return new Claim(vocId, userId, 1000L, com.teamfresh.vossystem.Member.DRIVER);
    }
}
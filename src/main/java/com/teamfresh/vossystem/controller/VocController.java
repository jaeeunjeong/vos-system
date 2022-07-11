package com.teamfresh.vossystem.controller;

import com.teamfresh.vossystem.dto.VocCreateRequestDto;
import com.teamfresh.vossystem.dto.response.Response;
import com.teamfresh.vossystem.service.VocService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class VocController {

    private final VocService vocService;

    @GetMapping("/api/vocAll")
    public Response readVOCList() {
        return Response.success(vocService.findAllVocList());
    }

    @PostMapping("/api/voc") //
    public Response addVocList(VocCreateRequestDto req) {
        vocService.insertVOC(req);
        return Response.success();
    }
}

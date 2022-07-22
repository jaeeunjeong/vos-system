package com.teamfresh.vossystem.service.voc;

import com.teamfresh.vossystem.dto.voc.VocCreateRequestDto;
import com.teamfresh.vossystem.dto.voc.VocListResponseDto;
import com.teamfresh.vossystem.entity.voc.Voc;
import com.teamfresh.vossystem.repository.voc.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VocService {

    private final VocRepository vocRepository;

    public List<VocListResponseDto> findAllVocList() {
        List<Voc> vocList = vocRepository.findAll();
        return VocListResponseDto.toDtoList(vocList);
    }

    @Transactional
    public void insertVOC(VocCreateRequestDto req) {
        vocRepository.save(VocCreateRequestDto.toEntity(req));
    }
}

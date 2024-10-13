package com.kb.saving.service;

import com.kb.saving.domain.Saving;
import com.kb.saving.dto.SavingAddPrimeRateDTO;
import com.kb.saving.dto.SavingDTO;
import com.kb.saving.mapper.SavingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.properties"})
public class SavingService {

    private final SavingMapper mapper;

    public List<SavingDTO> getSavingProduct() {
        List<SavingDTO> SavingList = mapper.selectSaving();
        return SavingList;
    }

    public List<SavingAddPrimeRateDTO> getAllSavingList() {
        return mapper.selectAllSaving();
    }

    public void addSaving(Saving saving) {
        int result = mapper.insertSaving(saving);
        if(result != 1) {
            throw new IllegalArgumentException("적금 등록에 실패했습니다.");
        }

    }
}
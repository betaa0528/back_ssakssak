package com.kb.saving.service;

import com.kb.saving.domain.PrimeRate;
import com.kb.saving.domain.Saving;
import com.kb.saving.dto.SavingAddPrimeRateDTO;
import com.kb.saving.dto.SavingAddRequest;
import com.kb.saving.dto.SavingDTO;
import com.kb.saving.mapper.SavingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.yml"})
public class SavingService {

    private final SavingMapper mapper;

    public List<SavingDTO> getSavingProduct() {
        List<SavingDTO> SavingList = mapper.selectSaving();
        return SavingList;
    }

    public List<SavingAddPrimeRateDTO> getAllSavingList() {
        return mapper.selectAllSaving();
    }

    @Transactional
    public void addSaving(SavingAddRequest request) {
        Saving saving = new Saving(request.getSavingName(), request.getSavingContent(),
                request.getMaxDeposit(), request.getSavingPeriod(), request.getSavingCycle(),
                request.getRate(), request.getImg(), request.getIsPrime());
        mapper.insertSaving(saving);
        if(request.getIsPrime() == 'Y') {
            List<Long> jobList = request.getJobList();
            for (Long id : jobList) {
                mapper.insertPrimeRate(new PrimeRate(saving.getSavingId(), request.getPrimeRate(), id));
            }
        }
    }

    public void deleteSaving(long id) {
        mapper.deleteSavingById(id);
    }
}
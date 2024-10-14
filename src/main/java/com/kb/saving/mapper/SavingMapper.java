package com.kb.saving.mapper;

import com.kb.saving.domain.PrimeRate;
import com.kb.saving.domain.Saving;
import com.kb.saving.dto.SavingAddPrimeRateDTO;
import com.kb.saving.dto.SavingDTO;

import java.util.List;

public interface SavingMapper {
    List<SavingDTO> selectSaving();

    List<SavingAddPrimeRateDTO> selectAllSaving();

    void insertSaving(Saving saving);

    void insertPrimeRate(PrimeRate primeRate);

    void deleteSavingById(long id);
}
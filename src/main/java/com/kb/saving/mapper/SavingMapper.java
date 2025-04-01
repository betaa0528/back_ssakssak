package com.kb.saving.mapper;

import com.kb.saving.domain.PrimeRate;
import com.kb.saving.domain.Saving;
import com.kb.saving.dto.SavingAddPrimeRateDTO;
import com.kb.saving.dto.SavingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SavingMapper {
    List<SavingDTO> selectSaving();

    List<SavingAddPrimeRateDTO> selectAllSaving();

    void insertSaving(Saving saving);

    void insertPrimeRate(PrimeRate primeRate);

    void deleteSavingById(long id);
}
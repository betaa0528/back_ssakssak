package com.kb.saving.mapper;

import com.kb.saving.dto.SavingDTO;

import java.util.List;

public interface SavingMapper {
    List<SavingDTO> selectSaving();
}
package com.kb.store.service;

import com.kb.store.dto.StoreDTO;
import com.kb.store.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
@PropertySource({"classpath:/application.properties"})
public class StoreService {

    private final StoreMapper storeMapper;

    @Value("${file_save_location_win}")
    private String uploadPath;

    public void registerStore(StoreDTO storeDTO) {
        storeMapper.insertStore(storeDTO);
    }

    public List<StoreDTO> getAllStores() {
        return storeMapper.getStoreList();
    }

    public String saveFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String filePath = uploadPath + fileName;

        try {
            File dest = new File(filePath);
            file.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException("error", e);
        }

        return "/images/" + fileName;
    }
}
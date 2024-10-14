package com.kb.controller.teacher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kb.store.dto.StoreDTO;
import com.kb.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/teacher/store")
public class TeacherStoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/coupon-apply")
    public ResponseEntity<String> applyCoupon(
            @RequestPart("storeDTO") String storeDTOString,
            @RequestPart("file") MultipartFile file) throws JsonProcessingException {

        // storeDTOString을 JSON으로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        StoreDTO storeDTO = objectMapper.readValue(storeDTOString, StoreDTO.class);

        String filePath = storeService.saveFile(file);
        storeDTO.setCpImage(filePath);

        storeService.registerStore(storeDTO);
        return ResponseEntity.ok("Coupon apply successfully!");
    }

    @GetMapping("/coupon-list")
    public List<StoreDTO> getStoreList() {
        return storeService.getAllStores();
    }
}
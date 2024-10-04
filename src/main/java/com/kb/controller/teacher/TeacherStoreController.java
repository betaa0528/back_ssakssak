package com.kb.controller.teacher;

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
            @RequestPart("storeDTO") StoreDTO storeDTO,
            @RequestPart("file") MultipartFile file) {

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
package com.kb.controller.student;

import com.kb.store.dto.StoreDTO;
import com.kb.store.service.StoreService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student/store")
@RequiredArgsConstructor
@Slf4j
@Api(value= "StudentStoreController", tags = "학생 매점 정보")
@PropertySource({"classpath:/application.properties"})
public class StudentStoreController {

    private final StoreService StoreService;

    @GetMapping("/data")
    public ResponseEntity<List<StoreDTO>> getStores() {
        List<StoreDTO> Stores = StoreService.getAllStores();
        return ResponseEntity.ok(Stores);
    }

}
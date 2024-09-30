package com.kb.controller.student;

import com.kb.saving.domain.Saving;
import com.kb.saving.dto.SavingDTO;
import com.kb.saving.service.SavingService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student/saving")
@RequiredArgsConstructor
@Slf4j
@Api(value= "StudentSavingController", tags = "학생 주식 정보")
@PropertySource({"classpath:/application.properties"})
public class StudentBankController {

    private final SavingService SavingService;

    @GetMapping("/data")
    public ResponseEntity<List<SavingDTO>> getSavingProduct() {
        List<SavingDTO> SavingList = SavingService.getSavingProduct();

        return ResponseEntity.ok(SavingList);
    }


}
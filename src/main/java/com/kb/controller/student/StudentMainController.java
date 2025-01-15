package com.kb.controller.student;

import com.kb.student.dto.SeedRankingDTO;
import com.kb.student.dto.StudentDTO;
import com.kb.student.dto.StudentSalaryDTO;
import com.kb.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/home")
@RequiredArgsConstructor
@Slf4j
public class StudentMainController {

    private final StudentService studentService;

    @GetMapping("/my-seed/{stdId}")
    public ResponseEntity<List<SeedRankingDTO>> getStudentSeed() {
        List<SeedRankingDTO> studentSeed = studentService.getStudentSeed();
        return ResponseEntity.ok(studentSeed);
    }

    @GetMapping("/seedranking")
    public ResponseEntity<List<SeedRankingDTO>> getSeedRankingThree() {
        List<SeedRankingDTO> seedRankingThree = studentService.getSeedRankingThree();
        return ResponseEntity.ok(seedRankingThree);
    }



}

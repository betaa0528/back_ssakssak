package com.kb.controller.teacher;

import com.kb.job.dto.JobDTO;
import com.kb.job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher/student")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping("/job-list")
    public List<JobDTO> getJobList() {
        return jobService.getAllJobs();
    }

    @PostMapping("/job-apply")
    public ResponseEntity<String> registerJob(@RequestBody JobDTO jobDTO) {
        try {
            jobService.registerJob(jobDTO);
            return ResponseEntity.ok("successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/job-update")
    public String updateJob(@RequestBody JobDTO jobDTO) {
        jobService.updateJob(jobDTO);
        return "Job updated successfully!";
    }
}
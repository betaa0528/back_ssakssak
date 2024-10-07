package com.kb.job.service;

import com.kb.job.dto.JobDTO;
import com.kb.job.mapper.JobMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobMapper jobMapper;

    public List<JobDTO> getAllJobs() {
        return jobMapper.getJobList();
    }

    public void registerJob(JobDTO jobDTO) {
        int jobCount = jobMapper.checkJobExistsByName(jobDTO.getJobName());
        if (jobCount > 0) {
            throw new IllegalArgumentException("already exists: " + jobDTO.getJobName());
        }

        jobMapper.insertJob(jobDTO);
    }
}
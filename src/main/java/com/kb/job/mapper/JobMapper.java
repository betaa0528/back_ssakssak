package com.kb.job.mapper;

import com.kb.job.dto.JobDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JobMapper {
    List<JobDTO> getJobList();
    int checkJobExistsByName(String jobName);
    void insertJob(JobDTO jobDTO);
    void updateJob(@Param("job") JobDTO job);
}
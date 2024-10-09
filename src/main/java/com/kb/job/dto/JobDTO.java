package com.kb.job.dto;

import lombok.Data;

@Data
public class JobDTO {
    private Long jobId;
    private String jobName;
    private String jobContent;
    private String isPrime;
}
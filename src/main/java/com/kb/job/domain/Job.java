package com.kb.job.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Job {
    private Long jobId;
    private String jobName;
    private String jobContent;
    private String isPrime;
}

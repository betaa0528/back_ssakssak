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
    private long jobId;
    private long stdId;
    private long tchId;
    private String jobName;
    private char isPrime;
}

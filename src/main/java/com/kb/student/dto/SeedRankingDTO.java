package com.kb.student.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeedRankingDTO {
    private long stdId;
    private String stdName;
    private int seed;
}

package com.kb.reward.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RewardGiveDTO {
    private long giveId;
    private String giveDate;
    private String stdName;
    private String rewardName;
    private int giveSeed;
}

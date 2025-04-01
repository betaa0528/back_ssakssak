package com.kb.reward.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RewardDTO {
    private long rewardId;
    private String rewardName;
    private int rewardSeed;

    private RewardDTO(String rewardName, int rewardSeed) {
        this.rewardName = rewardName;
        this.rewardSeed = rewardSeed;
    }

    public static RewardDTO of(RewardRequest request) {
        return new RewardDTO(request.getRewardName(), request.getRewardSeed());
    }
}

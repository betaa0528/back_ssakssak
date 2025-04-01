package com.kb.reward.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RewardGiveParam {
    private int amount;
    private int page = 1;
    private int limit;
    private int offset;
}

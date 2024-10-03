package com.kb.reward.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RewardGive {
    private long giveId;
    private long rewardId;
    private LocalDateTime giveDate;
    private long stdId;
    private long tchId;
}

package com.kb.rewardGive.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class rewardGive {
    private long giveId;
    private long rewardId;
    private Date giveDate;
    private long stdId;
    private long tchId;
}

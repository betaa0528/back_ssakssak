package com.kb.reward.dto;

import com.kb.common.pagination.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RewardGivePageResult {
    private List<RewardGiveDTO> rewardList;
    private RewardGiveParam rewardGiveParam;
    private PageInfo pageInfo;
    private int totalCount;
}

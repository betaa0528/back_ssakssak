package com.kb.reward.mapper;

import com.kb.reward.domain.Reward;
import com.kb.reward.dto.*;

import java.util.List;

public interface RewardMapper {

    List<Reward> selectRewardList();

    int deleteRewardById(long rewardId);

    Reward selectRewardById(long rewardId);

    int insertReward(RewardDTO rewardDTO);

    List<RewardStudentDTO> selectStudentsList();

    List<RewardGiveDTO> selectRewardGiveList();

    int insertRewardGiveHistory(RewardGiveRequest rewardGiveRequest);
}

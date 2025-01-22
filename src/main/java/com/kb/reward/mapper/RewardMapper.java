package com.kb.reward.mapper;

import com.kb.reward.domain.Reward;
import com.kb.reward.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RewardMapper {

    List<Reward> selectRewardList();

    int deleteRewardById(long rewardId);

    Reward selectRewardById(long rewardId);

    int insertReward(RewardDTO rewardDTO);

    List<RewardStudentDTO> selectStudentsList(String userName);

    List<RewardGiveDTO> selectRewardGiveList(RewardGiveParam rewardGiveParam);

    int insertRewardGiveHistory(@Param("rewardId") long rewardId,@Param("stdId") long stdId,@Param("tchId") long tchId);

    int selectRewardGiveCount(RewardGiveParam rewardGiveParam);
}
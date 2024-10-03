package com.kb.reward.service;

import com.kb.reward.domain.Reward;
import com.kb.reward.dto.*;
import com.kb.reward.mapper.RewardMapper;
import com.kb.student.mapper.StudentMapper;
import com.kb.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j
public class RewardService {

    private final RewardMapper rewardMapper;
    private final StudentMapper studentMapper;

    public List<Reward> getAllRewardList() {
        return rewardMapper.selectRewardList();
    }

    public Reward deleteRewardById(long rewardId) {
        Reward reward = getRewardById(rewardId);
        int result = rewardMapper.deleteRewardById(rewardId);
        if (result != 1) {
            throw new NoSuchElementException();
        }
        return reward;
    }

    public Reward getRewardById(long rewardId) {
        Reward reward = rewardMapper.selectRewardById(rewardId);
        return Optional.of(reward).orElseThrow(NoSuchElementException::new);
    }

    public Reward addReward(RewardRequest request) {
        RewardDTO rewardDTO = RewardDTO.of(request);
        int result = rewardMapper.insertReward(rewardDTO);
        if (result != 1) {
            throw new NoSuchElementException();
        }
        return getRewardById(rewardDTO.getRewardId());
    }

    public List<RewardStudentDTO> getRewardStudentList() {
        return rewardMapper.selectStudentsList();
    }


    public List<RewardGiveDTO> getAllRewardGiveList() {
        return rewardMapper.selectRewardGiveList();
    }

    @Transactional
    public void giveRewardToStudents(List<RewardGiveRequest> rewardGiveRequestList) {
        Reward reward = rewardMapper.selectRewardById(rewardGiveRequestList.get(0).getRewardId());
        for (RewardGiveRequest request : rewardGiveRequestList) {
            int updateResult = studentMapper.updateStudentSeed(request.getStdId(), reward.getRewardSeed());
            if (updateResult != 1) {
                throw new NoSuchElementException();
            }
            int insertResult = rewardMapper.insertRewardGiveHistory(request);
            if (insertResult != 1) {
                throw new NoSuchElementException();
            }
        }
    }
}

package com.kb.reward.service;

import com.kb.common.pagination.PageInfo;
import com.kb.member.dto.Member;
import com.kb.reward.domain.Reward;
import com.kb.reward.dto.*;
import com.kb.reward.mapper.RewardMapper;
import com.kb.student.mapper.StudentMapper;
import com.kb.student.service.StudentService;
import com.kb.teacher.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j
public class RewardService {

    private final RewardMapper rewardMapper;
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;
    private static final int PAGE_LIMIT = 5;
    private static final int LIST_LIMIT = 10;

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

    public List<RewardStudentDTO> getRewardStudentList(String userName) {
        return rewardMapper.selectStudentsList(userName);
    }


    public RewardGivePageResult getAllRewardGiveList(RewardGiveParam rewardGiveParam) {
        int totalSize = rewardMapper.selectRewardGiveCount(rewardGiveParam);
        int listLimit = LIST_LIMIT;
        PageInfo pageInfo = new PageInfo(rewardGiveParam.getPage(), totalSize, listLimit, PAGE_LIMIT);
        rewardGiveParam.setLimit(pageInfo.getListLimit());
        rewardGiveParam.setOffset(pageInfo.getStartList()-1);
        List<RewardGiveDTO> giveList = rewardMapper.selectRewardGiveList(rewardGiveParam);
        if(giveList == null || giveList.isEmpty()) {
            giveList = new ArrayList<>();
        }
        return new RewardGivePageResult(giveList, rewardGiveParam, pageInfo, totalSize);
    }

    @Transactional
    public void giveRewardToStudents(RewardGiveRequest rewardGiveRequestList, Member teacher) {
        long tchId = teacherMapper.selectByTeacherProfile(teacher.getUsername()).getTchId();
        Reward reward = rewardMapper.selectRewardById(rewardGiveRequestList.getRewardId());
        for (RewardStudentDTO dto : rewardGiveRequestList.getStudents()) {
            int updateResult = studentMapper.updateStudentSeed(dto.getStdId(), reward.getRewardSeed());
            if (updateResult != 1) {
                throw new NoSuchElementException();
            }
            int insertResult = rewardMapper.insertRewardGiveHistory(reward.getRewardId(), dto.getStdId(),  tchId);
            if (insertResult != 1) {
                throw new NoSuchElementException();
            }
        }
    }
}

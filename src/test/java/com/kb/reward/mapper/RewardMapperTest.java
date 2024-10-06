package com.kb.reward.mapper;

import com.kb._config.RootConfig;
import com.kb.reward.domain.Reward;
import com.kb.reward.dto.RewardDTO;
import com.kb.reward.dto.RewardGiveDTO;
import com.kb.reward.dto.RewardRequest;
import com.kb.reward.dto.RewardStudentDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
class RewardMapperTest {

    @Autowired
    RewardMapper rewardMapper;

    @Test
    @DisplayName("리워드 목록을 불러온다.")
    void getAllRewardListTest() {
        List<Reward> rewardList = rewardMapper.selectRewardList();
        assertNotNull(rewardList);
    }

    @Test
    @Transactional
    @DisplayName("리워드의 ID로 해당 리워드를 삭제한다")
    void deleteRewardTest() {
        List<Reward> rewardList = rewardMapper.selectRewardList();
        int preListSize = rewardList.size();
        rewardMapper.deleteRewardById(rewardList.get(0).getRewardId());
        rewardList = rewardMapper.selectRewardList();
        assertEquals(preListSize - 1, rewardList.size());
    }

    @Test
    @Transactional
    @DisplayName("새로운 리워드를 등록한다.")
    void insertRewardTest() {
        List<Reward> rewardList = rewardMapper.selectRewardList();
        int preListSize = rewardList.size();
        RewardRequest request = new RewardRequest("테스트 리워드", 100);
        rewardMapper.insertReward(RewardDTO.of(request));
        rewardList = rewardMapper.selectRewardList();

        assertEquals(preListSize + 1, rewardList.size());
        assertEquals(rewardList.get(rewardList.size()-1).getRewardName() , "테스트 리워드");
    }

    @Test
    @DisplayName("선생님의 주식관리 페이지에서 학생들의 목록을 불러온다.")
    void getStudentsList() {
        List<RewardStudentDTO> rewardStudentList = rewardMapper.selectStudentsList();
        assertEquals("박민주", rewardStudentList.get(0).getStdName());
    }

    @Test
    @DisplayName("리워드 지급 내역을 불러온다")
    void getRewardGiveList() {
        List<RewardGiveDTO> rewardGiveList = rewardMapper.selectRewardGiveList();
        assertEquals("책 읽기 시간 참여", rewardGiveList.get(0).getRewardName());
    }
}
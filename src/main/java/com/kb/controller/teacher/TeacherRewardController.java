package com.kb.controller.teacher;

import com.kb.member.dto.Member;
import com.kb.reward.domain.Reward;
import com.kb.reward.dto.*;
import com.kb.reward.service.RewardService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j
@RequestMapping("/api/teacher/reward")
@Api(value = "TeacherRewardController", tags = "선생님 리워드 관리 페이지")
@PropertySource({"classpath:/application.properties"})
public class TeacherRewardController {

    private final RewardService rewardService;

    @GetMapping("/list")
    public ResponseEntity<List<Reward>> getRewardList() {
        List<Reward> rewardList = rewardService.getAllRewardList();
        return ResponseEntity.ok(rewardList);
    }

    @PostMapping("/{rewardId}")
    public ResponseEntity<Reward> deleteRewardById(@PathVariable long rewardId) {
        Reward reward = rewardService.deleteRewardById(rewardId);
        return ResponseEntity.ok(reward);
    }

    @PostMapping("/apply")
    public ResponseEntity<Reward> applyReward(@RequestBody RewardRequest request) {
        Reward reward = rewardService.addReward(request);

        return ResponseEntity.ok(reward);
    }

    @GetMapping("/student-list")
    public ResponseEntity<List<RewardStudentDTO>> getStudentList(@AuthenticationPrincipal Member member) {
        List<RewardStudentDTO> rewardStudentList = rewardService.getRewardStudentList(member.getUsername());
        return ResponseEntity.ok(rewardStudentList);
    }

    @GetMapping("/pay/list")
    public ResponseEntity<RewardGivePageResult> getRewardGiveList(RewardGiveParam rewardGiveParam) {
        RewardGivePageResult result = rewardService.getAllRewardGiveList(rewardGiveParam);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/pay")
    public ResponseEntity<String> giveReward(@RequestBody RewardGiveRequest rewardGiveRequestList,
                                             @AuthenticationPrincipal Member teacher) {
        rewardService.giveRewardToStudents(rewardGiveRequestList, teacher);
        return ResponseEntity.ok("정상적으로 리워드가 지급 됐습니다.");
    }
}

package com.kb.controller.teacher;

import com.kb.reward.domain.Reward;
import com.kb.reward.dto.RewardGiveDTO;
import com.kb.reward.dto.RewardGiveRequest;
import com.kb.reward.dto.RewardRequest;
import com.kb.reward.dto.RewardStudentDTO;
import com.kb.reward.service.RewardService;
import com.kb.student.domain.Student;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<RewardStudentDTO>> getStudentList() {
        List<RewardStudentDTO> rewardStudentList = rewardService.getRewardStudentList();
        return ResponseEntity.ok(rewardStudentList);
    }

    @GetMapping("/pay/list")
    public ResponseEntity<List<RewardGiveDTO>> getRewardGiveList() {
        List<RewardGiveDTO> allRewardGiveList = rewardService.getAllRewardGiveList();
        return ResponseEntity.ok(allRewardGiveList);
    }

    @PostMapping("/pay")
    public ResponseEntity<String> giveReward(@RequestBody List<RewardGiveRequest> rewardGiveRequestList) {
        rewardService.giveRewardToStudents(rewardGiveRequestList);



        return ResponseEntity.ok("정상적으로 리워드가 지급 됐습니다.");
    }
}

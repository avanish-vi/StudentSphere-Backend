package com.studentsphere.controller;

import com.studentsphere.service.RewardService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(
            RewardService rewardService
    ) {
        this.rewardService =
                rewardService;
    }


    /*
     * GET REWARD BALANCE
     */
    @GetMapping("/{userId}/rewards")
    public Integer getRewardBalance(
            @PathVariable Long userId
    ) {

        return rewardService
                .getRewardBalance(userId);
    }


    /*
     * GET COMPLETED TASK IDS
     */
    @GetMapping(
            "/{userId}/completed-tasks"
    )
    public List<Long> getCompletedTaskIds(
            @PathVariable Long userId
    ) {

        return rewardService
                .getCompletedTaskIds(userId);
    }


    /*
     * COMPLETE TASK
     */
    @PostMapping(
            "/{userId}/tasks/{taskId}"
    )
    public Integer completeTask(
            @PathVariable Long userId,
            @PathVariable Long taskId
    ) {

        return rewardService
                .completeTask(
                        userId,
                        taskId
                );
    }
}
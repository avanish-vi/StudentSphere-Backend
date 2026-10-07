package com.studentsphere.service;

import com.studentsphere.entity.RewardTransaction;
import com.studentsphere.entity.Task;
import com.studentsphere.entity.User;

import com.studentsphere.repository.RewardTransactionRepository;
import com.studentsphere.repository.TaskRepository;
import com.studentsphere.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardService {

    private final UserRepository userRepository;

    private final TaskRepository taskRepository;

    private final RewardTransactionRepository rewardTransactionRepository;

    public RewardService(
            UserRepository userRepository,
            TaskRepository taskRepository,
            RewardTransactionRepository rewardTransactionRepository
    ) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.rewardTransactionRepository =
                rewardTransactionRepository;
    }


    /*
     * GET CURRENT REWARD BALANCE
     */
    public Integer getRewardBalance(
            Long userId
    ) {

        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found."
                                )
                        );

        Integer points =
                user.getRewardPoints();

        return points == null
                ? 0
                : points;
    }


    /*
     * GET COMPLETED TASK IDS
     */
    public List<Long> getCompletedTaskIds(
            Long userId
    ) {

        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found."
                                )
                        );

        return rewardTransactionRepository
                .findByUser(user)
                .stream()
                .map(transaction ->
                        transaction
                                .getTask()
                                .getId()
                )
                .collect(Collectors.toList());
    }


    /*
     * COMPLETE TASK
     */
    @Transactional
    public Integer completeTask(
            Long userId,
            Long taskId
    ) {

        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found."
                                )
                        );

        Task task =
                taskRepository
                        .findById(taskId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Task not found."
                                )
                        );


        /*
         * CHECK IF ALREADY COMPLETED
         */
        List<RewardTransaction> existing =
                rewardTransactionRepository
                        .findByUserAndTask(
                                user,
                                task
                        );


        if (!existing.isEmpty()) {

            return user.getRewardPoints();
        }


        /*
         * CREATE TRANSACTION
         */
        RewardTransaction transaction =
                new RewardTransaction();

        transaction.setUser(user);

        transaction.setTask(task);

        transaction.setPoints(
                task.getReward()
        );

        rewardTransactionRepository.save(
                transaction
        );


        /*
         * UPDATE USER POINTS
         */
        Integer currentPoints =
                user.getRewardPoints();

        if (currentPoints == null) {
            currentPoints = 0;
        }

        int newPoints =
                currentPoints +
                        task.getReward();

        user.setRewardPoints(
                newPoints
        );

        userRepository.save(user);

        userRepository.flush();

        return newPoints;
    }
}
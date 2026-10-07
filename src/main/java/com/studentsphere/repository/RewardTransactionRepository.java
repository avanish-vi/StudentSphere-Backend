package com.studentsphere.repository;

import com.studentsphere.entity.RewardTransaction;
import com.studentsphere.entity.Task;
import com.studentsphere.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RewardTransactionRepository
        extends JpaRepository<RewardTransaction, Long> {

    List<RewardTransaction> findByUserAndTask(
            User user,
            Task task
    );

    List<RewardTransaction> findByUser(
            User user
    );
}
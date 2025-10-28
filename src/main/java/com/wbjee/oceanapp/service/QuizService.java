package com.wbjee.oceanapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wbjee.oceanapp.model.QuizAttempt;
import com.wbjee.oceanapp.repository.QuizAttemptRepository;

@Service
public class QuizService {

    private final QuizAttemptRepository attemptRepo;

    public QuizService(QuizAttemptRepository attemptRepo) {
        this.attemptRepo = attemptRepo;
    }

    @Transactional
    public QuizAttempt saveAttempt(QuizAttempt attempt) {
        // guard nulls (if ever changed to Integer)
        int physics = attempt.getPhysicsScore();
        int chemistry = attempt.getChemistryScore();
        int math = attempt.getMathScore();

        int total = physics + chemistry + math;
        attempt.setTotalScore(total);

        // ensure attemptNumber is at least 1
        if (attempt.getAttemptNumber() <= 0) {
            attempt.setAttemptNumber(1);
        }

        return attemptRepo.save(attempt);
    }
}

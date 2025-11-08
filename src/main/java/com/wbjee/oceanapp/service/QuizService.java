package com.wbjee.oceanapp.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.wbjee.oceanapp.repository.QuizAttemptRepository;
import com.wbjee.oceanapp.repository.AttemptAnswerRepository;
import com.wbjee.oceanapp.repository.QuestionRepository;
import com.wbjee.oceanapp.model.QuizAttempt;
import com.wbjee.oceanapp.model.AttemptAnswer;
import com.wbjee.oceanapp.model.Question;
import com.wbjee.oceanapp.dto.quiz.AttemptSubmitRequest;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired private QuizAttemptRepository attemptRepo;
    @Autowired private AttemptAnswerRepository answerRepo;
    @Autowired private QuestionRepository questionRepo;

    public QuizAttempt submitAttempt(AttemptSubmitRequest req) {
        if (req.getAnswers() == null || req.getAnswers().isEmpty()) {
            throw new IllegalArgumentException("No answers submitted");
        }
        QuizAttempt attempt = new QuizAttempt();
        attempt.setUserId(req.getUserId());
        attempt.setSetId(req.getSetId());
        attempt.setAttemptNumber(req.getAttemptNumber() == null ? 1 : req.getAttemptNumber());
        attempt.setStatus("SUBMITTED");
        attempt.setSubmittedAt(OffsetDateTime.now());

        // Compute scores
        int total = 0;
        int max = 0;
        List<AttemptAnswer> savedAnswers = new ArrayList<>();

        // Save attempt first to generate ID
        QuizAttempt persisted = attemptRepo.save(attempt);

        for (AttemptSubmitRequest.AnswerDto a : req.getAnswers()) {
            Optional<Question> qOpt = questionRepo.findById(a.getQuestionId());
            if (qOpt.isEmpty()) continue; // ignore missing questions
            Question q = qOpt.get();
            int qMarks = q.getMarks() == null ? 1 : q.getMarks();
            max += qMarks;
            AttemptAnswer ans = new AttemptAnswer();
            ans.setAttemptId(persisted.getId());
            ans.setQuestionId(q.getId());
            ans.setSelectedOption(a.getSelectedOption());
            boolean isCorrect = (a.getSelectedOption() != null && q.getCorrectOption() != null)
                    && Character.toUpperCase(a.getSelectedOption()) == Character.toUpperCase(q.getCorrectOption());
            ans.setIsCorrect(isCorrect);
            ans.setMarksAwarded(isCorrect ? qMarks : 0);
            ans.setAnsweredAt(OffsetDateTime.now());
            savedAnswers.add(answerRepo.save(ans));
            total += (isCorrect ? qMarks : 0);
        }

        persisted.setTotalScore(total);
        persisted.setMaxScore(max);
        persisted.setStatus("SUBMITTED");
        persisted.setSubmittedAt(OffsetDateTime.now());
        persisted = attemptRepo.save(persisted);
        return persisted;
    }
}

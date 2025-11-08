package com.wbjee.oceanapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.wbjee.oceanapp.dto.quiz.AttemptSubmitRequest;
import com.wbjee.oceanapp.service.QuizService;
import com.wbjee.oceanapp.model.QuizAttempt;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired private QuizService quizService;

    @PostMapping("/submit")
    public ResponseEntity<QuizAttempt> submit(@RequestBody AttemptSubmitRequest req) {
        QuizAttempt attempt = quizService.submitAttempt(req);
        return ResponseEntity.ok(attempt);
    }
}

package com.wbjee.oceanapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wbjee.oceanapp.model.QuizAttempt;
import com.wbjee.oceanapp.service.QuizService;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/submit")
    public ResponseEntity<QuizAttempt> submitQuiz(@RequestBody QuizAttempt attempt) {
        QuizAttempt saved = quizService.saveAttempt(attempt);
        return ResponseEntity.ok(saved);
    }
}

package com.wbjee.oceanapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wbjee.oceanapp.model.ChemistryQuestion;
import com.wbjee.oceanapp.model.MathQuestion;
import com.wbjee.oceanapp.model.PhysicsQuestion;
import com.wbjee.oceanapp.service.QuestionService;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/physics/{set}")
    public ResponseEntity<List<PhysicsQuestion>> getPhysics(@PathVariable int set) {
        return ResponseEntity.ok(questionService.getPhysicsQuestionsBySet(set));
    }

    @GetMapping("/chemistry/{set}")
    public ResponseEntity<List<ChemistryQuestion>> getChemistry(@PathVariable int set) {
        return ResponseEntity.ok(questionService.getChemistryQuestionsBySet(set));
    }

    @GetMapping("/math/{set}")
    public ResponseEntity<List<MathQuestion>> getMath(@PathVariable int set) {
        return ResponseEntity.ok(questionService.getMathQuestionsBySet(set));
    }
}

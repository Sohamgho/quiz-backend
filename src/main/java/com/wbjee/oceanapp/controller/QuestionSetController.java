package com.wbjee.oceanapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.wbjee.oceanapp.model.QuestionSet;
import com.wbjee.oceanapp.repository.QuestionSetRepository;

import java.util.List;

@RestController
@RequestMapping("/api/sets")
public class QuestionSetController {
    @Autowired private QuestionSetRepository setRepo;

    @GetMapping
    public List<QuestionSet> all() {
        return setRepo.findAll();
    }

    @PostMapping
    public QuestionSet create(@RequestBody QuestionSet s) {
        // ensure slug unique; small helper
        if (s.getSlug() == null) {
            s.setSlug(s.getName().toLowerCase().replaceAll("\\s+","-"));
        }
        return setRepo.save(s);
    }

    @GetMapping("/{id}")
    public QuestionSet get(@PathVariable Long id) {
        return setRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Set not found"));
    }
}

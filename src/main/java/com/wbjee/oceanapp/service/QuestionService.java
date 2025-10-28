package com.wbjee.oceanapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wbjee.oceanapp.model.ChemistryQuestion;
import com.wbjee.oceanapp.model.MathQuestion;
import com.wbjee.oceanapp.model.PhysicsQuestion;
import com.wbjee.oceanapp.repository.ChemistryRepository;
import com.wbjee.oceanapp.repository.MathRepository;
import com.wbjee.oceanapp.repository.PhysicsRepository;

@Service
public class QuestionService {

    private final PhysicsRepository physicsRepo;
    private final ChemistryRepository chemistryRepo;
    private final MathRepository mathRepo;

    public QuestionService(PhysicsRepository physicsRepo,
                           ChemistryRepository chemistryRepo,
                           MathRepository mathRepo) {
        this.physicsRepo = physicsRepo;
        this.chemistryRepo = chemistryRepo;
        this.mathRepo = mathRepo;
    }

    public List<PhysicsQuestion> getPhysicsQuestionsBySet(int set) {
        return physicsRepo.findBySetNumber(set);
    }

    public List<ChemistryQuestion> getChemistryQuestionsBySet(int set) {
        return chemistryRepo.findBySetNumber(set);
    }

    public List<MathQuestion> getMathQuestionsBySet(int set) {
        return mathRepo.findBySetNumber(set);
    }
}

package com.wbjee.oceanapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz_attempts")
public class QuizAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private int setNumber;
    private int physicsScore;
    private int chemistryScore;
    private int mathScore;
    private int totalScore;

    @Column(nullable = false)
    private int attemptNumber = 1;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public int getSetNumber() { return setNumber; }
    public void setSetNumber(int setNumber) { this.setNumber = setNumber; }
    public int getPhysicsScore() { return physicsScore; }
    public void setPhysicsScore(int physicsScore) { this.physicsScore = physicsScore; }
    public int getChemistryScore() { return chemistryScore; }
    public void setChemistryScore(int chemistryScore) { this.chemistryScore = chemistryScore; }
    public int getMathScore() { return mathScore; }
    public void setMathScore(int mathScore) { this.mathScore = mathScore; }
    public int getTotalScore() { return totalScore; }
    public void setTotalScore(int totalScore) { this.totalScore = totalScore; }
    public int getAttemptNumber() { return attemptNumber; }
    public void setAttemptNumber(int attemptNumber) { this.attemptNumber = attemptNumber; }
}

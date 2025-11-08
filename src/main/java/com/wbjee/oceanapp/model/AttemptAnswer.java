package com.wbjee.oceanapp.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name="attempt_answers", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"attempt_id","question_id"})
})
public class AttemptAnswer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="attempt_id", nullable=false)
    private Long attemptId;

    @Column(name="question_id", nullable=false)
    private Long questionId;

    @Column(name="selected_option", length=1)
    private Character selectedOption;

    @Column(name="is_correct")
    private Boolean isCorrect;

    @Column(name="marks_awarded")
    private Integer marksAwarded = 0;

    @Column(name="answered_at")
    private OffsetDateTime answeredAt = OffsetDateTime.now();

    // getters & setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getAttemptId() { return attemptId; }
    public void setAttemptId(Long attemptId) { this.attemptId = attemptId; }
    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }
    public Character getSelectedOption() { return selectedOption; }
    public void setSelectedOption(Character selectedOption) { this.selectedOption = selectedOption; }
    public Boolean getIsCorrect() { return isCorrect; }
    public void setIsCorrect(Boolean isCorrect) { this.isCorrect = isCorrect; }
    public Integer getMarksAwarded() { return marksAwarded; }
    public void setMarksAwarded(Integer marksAwarded) { this.marksAwarded = marksAwarded; }
    public OffsetDateTime getAnsweredAt() { return answeredAt; }
    public void setAnsweredAt(OffsetDateTime answeredAt) { this.answeredAt = answeredAt; }
}

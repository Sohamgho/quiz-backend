package com.wbjee.oceanapp.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "quiz_attempts")
public class QuizAttempt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "set_id")
	private Long setId;

	@Column(name = "started_at")
	private OffsetDateTime startedAt = OffsetDateTime.now();

	@Column(name = "submitted_at")
	private OffsetDateTime submittedAt;

	@Column(name = "total_score")
	private Integer totalScore = 0;

	@Column(name = "max_score")
	private Integer maxScore = 0;

	private String status = "IN_PROGRESS";

	@Column(name = "attempt_number")
	private Integer attemptNumber = 1;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "attempt_id", referencedColumnName = "id", insertable = false, updatable = false)
	private List<AttemptAnswer> answers; // optional view

	// getters & setters...
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSetId() {
		return setId;
	}

	public void setSetId(Long setId) {
		this.setId = setId;
	}

	public OffsetDateTime getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(OffsetDateTime startedAt) {
		this.startedAt = startedAt;
	}

	public OffsetDateTime getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(OffsetDateTime submittedAt) {
		this.submittedAt = submittedAt;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(Integer maxScore) {
		this.maxScore = maxScore;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAttemptNumber() {
		return attemptNumber;
	}

	public void setAttemptNumber(Integer attemptNumber) {
		this.attemptNumber = attemptNumber;
	}

	public List<AttemptAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AttemptAnswer> answers) {
		this.answers = answers;
	}
}

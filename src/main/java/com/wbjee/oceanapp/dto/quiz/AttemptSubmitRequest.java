package com.wbjee.oceanapp.dto.quiz;

import java.util.List;

public class AttemptSubmitRequest {
	private Long userId;
	private Long setId;
	private Integer attemptNumber;
	private List<AnswerDto> answers;

	public static class AnswerDto {
		private Long questionId;
		private Character selectedOption;

		// getters & setters
		public Long getQuestionId() {
			return questionId;
		}

		public void setQuestionId(Long questionId) {
			this.questionId = questionId;
		}

		public Character getSelectedOption() {
			return selectedOption;
		}

		public void setSelectedOption(Character selectedOption) {
			this.selectedOption = selectedOption;
		}
	}

	// getters & setters...
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

	public Integer getAttemptNumber() {
		return attemptNumber;
	}

	public void setAttemptNumber(Integer attemptNumber) {
		this.attemptNumber = attemptNumber;
	}

	public List<AnswerDto> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerDto> answers) {
		this.answers = answers;
	}
}

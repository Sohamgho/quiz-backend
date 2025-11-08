package com.wbjee.oceanapp.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "questions", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "set_id", "sequence_num", "subject" }) })
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "set_id", nullable = false)
	private Long setId;

	@Column(nullable = false, length = 50)
	private String subject; // PHYSICS, CHEMISTRY, MATH

	@Column(name = "sequence_num", nullable = false)
	private Integer sequenceNum;

	@Column(name = "question_text", columnDefinition = "text", nullable = false)
	private String questionText;

	@Column(name = "option_a", columnDefinition = "text")
	private String optionA;

	@Column(name = "option_b", columnDefinition = "text")
	private String optionB;

	@Column(name = "option_c", columnDefinition = "text")
	private String optionC;

	@Column(name = "option_d", columnDefinition = "text")
	private String optionD;

	@Column(name = "correct_option", length = 1)
	private Character correctOption;

	private Integer marks = 1;

	@Column(name = "is_pyq")
	private Boolean isPyq = false;

	@Column(name = "pyq_year")
	private Integer pyqYear;

	@Column(name = "allow_preview")
	private Boolean allowPreview = true;

	@Column(name = "extra_json", columnDefinition = "jsonb")
	private String extraJson;

	@Column(name = "created_at")
	private OffsetDateTime createdAt = OffsetDateTime.now();

	// getters & setters...
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSetId() {
		return setId;
	}

	public void setSetId(Long setId) {
		this.setId = setId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getSequenceNum() {
		return sequenceNum;
	}

	public void setSequenceNum(Integer sequenceNum) {
		this.sequenceNum = sequenceNum;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public Character getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(Character correctOption) {
		this.correctOption = correctOption;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Boolean getIsPyq() {
		return isPyq;
	}

	public void setIsPyq(Boolean isPyq) {
		this.isPyq = isPyq;
	}

	public Integer getPyqYear() {
		return pyqYear;
	}

	public void setPyqYear(Integer pyqYear) {
		this.pyqYear = pyqYear;
	}

	public Boolean getAllowPreview() {
		return allowPreview;
	}

	public void setAllowPreview(Boolean allowPreview) {
		this.allowPreview = allowPreview;
	}

	public String getExtraJson() {
		return extraJson;
	}

	public void setExtraJson(String extraJson) {
		this.extraJson = extraJson;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}
}

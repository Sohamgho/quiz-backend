package com.wbjee.oceanapp.dto.question;

public class QuestionRequest {
	private Long setId;
	private String subject;
	private Integer sequenceNum;
	private String questionText;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private Character correctOption;
	private Integer marks;
	private Boolean isPyq;
	private Integer pyqYear;
	private Boolean allowPreview;
	private String extraJson; // JSON string if any

	// getters & setters...
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
}

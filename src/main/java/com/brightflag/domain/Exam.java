package com.brightflag.domain;

public class Exam {

	private Integer examID;
	private String examName;
	private Integer grade;
	private Integer subjectID;

	public Integer getExamID() {
		return examID;
	}

	public void setExamID(Integer examID) {
		this.examID = examID;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getsubjectID() {
		return subjectID;
	}

	public void setsubjectID(Integer grade) {
		this.grade = subjectID;
	}

	@Override
	public String toString() {
		return "Exam [examID=" + examID + ", examName=" + examName + "]";
	}

}

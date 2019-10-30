package com.brightflag.domain;

import com.brightflag.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private Integer studentID;
	private String firstName;
	private String lastName;
	private List<Subject> subjects;
	private List<Subject> subjectsAvailable;
	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSubjects(List subjects){this.subjects = subjects;}

	public List<Subject> getSubjects(){
		return subjects;
	}

	public void setSubjectsAvailable(List<Subject> all){
		List<Subject> subjectsList = new ArrayList<Subject>();
		for(Subject subj:all){
			int index = 0;
			for(Subject subject:this.subjects) {
				if(subject.getSubjectName()!=subj.getSubjectName()){
					index= index+1;
					if(index==this.subjects.size()) {
						subjectsList.add(subj);
					}
				}
			}}
			this.subjectsAvailable = subjectsList;
	}

	public List<Subject> getSubjectsAvailable(){
		return subjectsAvailable;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
package com.brightflag.controller;

import java.util.List;

import com.brightflag.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightflag.domain.Student;
import com.brightflag.service.StudentService;
import com.brightflag.service.SubjectService;

@RestController
public class StudentAPIController {

	@Autowired
	StudentService studentService;
	@Autowired
	SubjectService subjectService;

	@RequestMapping("api/getStudents")
	public List<Student> getStudents() {
		List<Subject> All = subjectService.getAllSubjects();
		List<Student> studentList = studentService.getStudents();
		for (Student student:studentList) {
			Integer id = student.getStudentID();
			List<Subject> subjectList = subjectService.getSubjects(id);
			student.setSubjects(subjectList);
			student.setSubjectsAvailable(All);
		}
		return studentList;
	}

}

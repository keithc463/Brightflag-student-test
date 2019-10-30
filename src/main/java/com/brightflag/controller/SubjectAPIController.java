package com.brightflag.controller;

import com.brightflag.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brightflag.service.SubjectService;

import java.util.List;

@RestController
public class SubjectAPIController {

	@Autowired
	SubjectService subjectService;

	@RequestMapping("api/getAllSubjects")
	public List<Subject> getAllSubjects(){
		List<Subject> subjectList = subjectService.getAllSubjects();
		return subjectList;
	}
    @RequestMapping("api/assignSubject")
	public boolean assignSubject(@RequestParam Integer studentID, @RequestParam Integer subjectID){
	    return subjectService.assignSubject(studentID, subjectID);
    }
}

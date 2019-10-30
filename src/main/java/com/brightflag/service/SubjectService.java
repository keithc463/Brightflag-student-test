package com.brightflag.service;

import com.brightflag.domain.Student;
import com.brightflag.domain.Subject;
import com.brightflag.repository.StudentRepository;
import com.brightflag.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getSubjects(Integer ID) {
        return subjectRepository.getSubjects(ID);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.getAllSubjects();
    }

    public boolean assignSubject(Integer studentID, Integer subjectName){
        return subjectRepository.assignSubject(studentID, subjectName);
    }

}

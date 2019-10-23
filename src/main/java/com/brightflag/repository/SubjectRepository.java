package com.brightflag.repository;

import java.util.List;

import com.brightflag.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.brightflag.domain.Student;

@Repository
public class SubjectRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Subject> getSubjects(Integer studentID) {
        return jdbcTemplate.query("SELECT subjectName FROM student where studentID = ?;",
                new BeanPropertyRowMapper<Subject>(Subject.class), studentID);
    }

}

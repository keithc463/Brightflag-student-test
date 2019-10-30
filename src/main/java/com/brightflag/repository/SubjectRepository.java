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
        return jdbcTemplate.query("SELECT Su.subjectID, Su.subjectName\n" +
                        "FROM Student AS S\n" +
                        "INNER JOIN studentsubject AS SS\n" +
                        "    ON S.studentID = SS.studentID\n" +
                        "INNER JOIN subject AS Su\n" +
                        "    ON SS.subjectID = Su.subjectID WHERE S.studentID = ?",
                new BeanPropertyRowMapper<Subject>(Subject.class), studentID);
    }

    public List<Subject> getAllSubjects() {
        return jdbcTemplate.query("SELECT subjectID, subjectName\n" +
                        "FROM Subject",
                new BeanPropertyRowMapper<Subject>(Subject.class));
    }

    public boolean assignSubject(Integer studentId, Integer subjectId) {
        int added= jdbcTemplate.update("INSERT INTO studentsubject(studentID,subjectID) VALUES (?,?)",
                studentId, subjectId);

        return (added == 1);
    }

}

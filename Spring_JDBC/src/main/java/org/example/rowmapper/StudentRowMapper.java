package org.example.rowmapper;

import org.example.api.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();

        student.setRoolNo(rs.getInt("ROOL_NO"));
        student.setName(rs.getString("STUDENT_NAME"));
        student.setAddress(rs.getString("STUDENT_ADDRESS"));

        System.out.println("mapRow() called");

        return student;
    }
}

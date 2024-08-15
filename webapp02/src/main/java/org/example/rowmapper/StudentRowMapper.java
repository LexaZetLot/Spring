package org.example.rowmapper;

import org.example.api.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("ID"));
        student.setName(rs.getString("NAME"));
        student.setMobile(rs.getLong("MOBILE"));
        student.setCountry(rs.getString("COUNTRY"));
        return student;
    }
}

package org.example.resultsetextractor;

import org.example.api.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>> {
    @Override
    public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Student> students = new ArrayList<Student>();
        while(rs.next()) {
            Student student = new Student();
            student.setRoolNo(rs.getInt("ROOL_NO"));
            student.setName(rs.getString("STUDENT_NAME"));
            student.setAddress(rs.getString("STUDENT_ADDRESS"));

            students.add(student);
        }
        System.out.println("inside the extracted method of ResultSetExtractor");

        return students;
    }
}

package org.example.resultsetextractor;

import org.example.api.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentAddressResultSetExtractor implements ResultSetExtractor<Map<String, List<Student>>> {
    @Override
    public Map<String, List<Student>> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<String, List<Student>> map = new HashMap<>();

        while (rs.next()) {
            Student student = new Student();
            student.setRoolNo(rs.getInt("ROOL_NO"));
            student.setName(rs.getString("STUDENT_NAME"));
            student.setAddress(rs.getString("STUDENT_ADDRESS"));

            if (map.get(student.getAddress()) == null) {
                List<Student> students = new ArrayList<>();
                students.add(student);
                map.put(student.getAddress(), students);
            } else
                map.get(student.getAddress()).add(student);
        }
        return map;
    }
}

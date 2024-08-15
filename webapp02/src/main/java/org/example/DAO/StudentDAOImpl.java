package org.example.DAO;

import org.example.api.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> loadStudents() {
        String sql = "SELECT ID as id, NAME as name, MOBILE as mobile, COUNTRY as country FROM STUDENT";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

    }

    @Override
    public void saveStudent(Student student) {
        String sql = "INSERT INTO STUDENT(NAME, MOBILE, COUNTRY) VALUES(?,?,?)";
        Object[] params = {student.getName(),student.getMobile(),student.getCountry()};
        jdbcTemplate.update(sql, params);
    }

    @Override
    public Student getStudent(int id) {
        String sql = "SELECT ID as id, NAME as name, MOBILE as mobile, COUNTRY as country FROM STUDENT WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE STUDENT SET NAME = ?,MOBILE = ?,COUNTRY = ? WHERE ID = ?";
        Object[] params = {student.getName(), student.getMobile(), student.getCountry(), student.getId()};
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM STUDENT WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
}

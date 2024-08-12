package org.example.dao;

import org.example.api.Student;
import org.example.resultsetextractor.StudentAddressResultSetExtractor;
import org.example.resultsetextractor.StudentResultSetExtractor;
import org.example.rowmapper.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Student student) {
        String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
        Object[] arg = {student.getRoolNo(), student.getName(), student.getAddress()};
        int noOfRoeInserted = jdbcTemplate.update(sql, arg);
        System.out.println("No of row inserted is " + noOfRoeInserted);
    }

    @Override
    public void insert(List<Student> students) {
        String sql = "INSERT INTO STUDENT(ROOL_NO, STUDENT_NAME, STUDENT_ADDRESS) VALUES(?,?,?)";
        ArrayList<Object[]> args = new ArrayList<>();
        for (Student student : students) {
            Object[] studentData = {student.getRoolNo(), student.getName(), student.getAddress()};
            args.add(studentData);
        }
        jdbcTemplate.batchUpdate(sql, args);
        System.out.println("Batch update completed");
    }

    @Override
    public boolean deleteRecordByRollNo(int rollNo) {
        String sql = "DELETE FROM STUDENT WHERE ROOL_NO = ?";
        int noOfRowDeleted = jdbcTemplate.update(sql, rollNo);
        System.out.println("No of row deleted is " + noOfRowDeleted);

        return noOfRowDeleted == 1;
    }

    @Override
    public int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress) {
        String sql = "DELETE FROM STUDENT WHERE STUDENT_NAME = ? OR STUDENT_ADDRESS = ?";
        return jdbcTemplate.update(sql, studentName, studentAddress);
    }

    @Override
    public List<Student> selectAllStudents() {
        String sql = "SELECT * FROM STUDENT";
        return jdbcTemplate.query(sql, new StudentResultSetExtractor());
    }

    @Override
    public void cleanUp() {
        String sql = "TRUNCATE TABLE STUDENT";
        jdbcTemplate.execute(sql);
    }

    @Override
    public Student findStudentByRollNo(int rollNo) {
        String sql = "SELECT ROOL_NO as roolNo, STUDENT_NAME as name, STUDENT_ADDRESS as address FROM STUDENT WHERE ROOL_NO = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), rollNo);
    }

    @Override
    public List<Student> findStudentByName(String studentName) {
        String sql = "SELECT * FROM STUDENT WHERE STUDENT_NAME = ?";
        return jdbcTemplate.query(sql, new StudentResultSetExtractor(), studentName);
    }

    @Override
    public Map<String, List<Student>> findStudentByAddress(String address) {
        String sql = "SELECT * FROM STUDENT WHERE STUDENT_ADDRESS = ?";
        List<Student> students = jdbcTemplate.query(sql, new StudentResultSetExtractor(), address);
        Map<String, List<Student>> map = new HashMap<>();
        map.put(address, students);
        return map;
    }

    @Override
    public Map<String, List<Student>> findStudentByAddressRowMapper(String address) {
        String sql = "SELECT * FROM STUDENT WHERE STUDENT_ADDRESS = ?";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper(), address);
        Map<String, List<Student>> map = new HashMap<>();
        map.put(address, students);
        return map;
    }

    @Override
    public Map<String, List<Student>> StudentAddressSet() {
        String sql = "SELECT * FROM STUDENT";
        return jdbcTemplate.query(sql, new StudentAddressResultSetExtractor());
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "UPDATE School.STUDENT SET STUDENT_ADDRESS = ? WHERE ROOL_NO = ?";
        return jdbcTemplate.update(sql, student.getAddress(), student.getRoolNo());
    }

    @Override
    @Transactional
    public int updateStudent(List<Student> students) {
        String sql = "UPDATE School.STUDENT SET STUDENT_ADDRESS = ? WHERE ROOL_NO = ?";
        int[] arr = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, students.get(i).getAddress());
                ps.setInt(2, students.get(i).getRoolNo());
            }

            @Override
            public int getBatchSize() {
                return students.size();
            }
        });
        int sum = 0;
        for (int i : arr)
            if (i == 1)
                sum++;


        return sum;
    }
}

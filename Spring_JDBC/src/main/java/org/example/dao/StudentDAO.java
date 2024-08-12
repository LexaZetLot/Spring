package org.example.dao;

import org.example.api.Student;

import java.util.List;
import java.util.Map;

public interface StudentDAO {
    void insert(Student student);
    void insert(List<Student> students);
    boolean deleteRecordByRollNo(int rollNo);
    int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress);
    List<Student> selectAllStudents();
    void cleanUp();
    Student findStudentByRollNo(int rollNo);
    public List<Student> findStudentByName(String studentName);
    public Map<String, List<Student>> findStudentByAddress(String address);
    public Map<String, List<Student>> findStudentByAddressRowMapper(String address);
    public Map<String, List<Student>> StudentAddressSet();
    int updateStudent(Student student);
    int updateStudent(List<Student> students);
}

package org.example.DAO;

import org.example.api.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> loadStudents();
    void saveStudent(Student student);
    Student getStudent(int id);
    void updateStudent(Student student);
    void deleteStudent(int id);
}

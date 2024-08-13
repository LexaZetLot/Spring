package org.example.DAO;

import org.example.api.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> loadStudents();
    void saveStudent(Student student);
}

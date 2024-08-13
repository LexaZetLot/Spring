package org.example.controllers;

import org.example.DAO.StudentDAO;
import org.example.api.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;

    @GetMapping(value = "/student-list")
    public String showStudentList(Model model){
        List<Student> studentList = studentDAO.loadStudents();
        model.addAttribute("studentList", studentList);

        return "student-list";
    }

    @GetMapping(value="/showAddStudentPage")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "add-student";
    }

    @ResponseBody
    @GetMapping(value="/save-student")
    public String saveStudent(Student student){
        studentDAO.saveStudent(student);
        return "student saved...";
    }
}

package org.example.controllers;

import org.example.api.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/student-list")
    public String showStudentList(Model model){
        List<Student> studentList = studentService.loadStudents();
        model.addAttribute("studentList", studentList);

        return "student-list";
    }

    @GetMapping(value="/showAddStudentPage")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "add-student";
    }

    @PostMapping(value="/save-student")
    public String saveStudent(Student student){
        if(student.getId() == 0)
            studentService.saveStudent(student);
        else
            studentService.upDateStudent(student);
        return "redirect:/student-list";
    }

    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("userId") int id, @ModelAttribute("student") Student student){
        Student stud_buf = studentService.getStudent(id);

        student.setId(stud_buf.getId());
        student.setName(stud_buf.getName());
        student.setMobile(stud_buf.getMobile());
        student.setCountry(stud_buf.getCountry());

        return "add-student";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("userId") int id, @ModelAttribute("student") Student student){
        studentService.deleteStudent(id);
        return "redirect:/student-list";
    }
}

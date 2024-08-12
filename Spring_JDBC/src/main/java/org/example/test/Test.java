package org.example.test;

import org.example.api.Student;
import org.example.dao.StudentDAO;
import org.example.service.StudentDAOHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        System.out.println("application context loaded...");

        StudentDAOHelper helper = context.getBean("studentDAOHelper", StudentDAOHelper.class);
        StudentDAO studentDAO = context.getBean("studentDAO", StudentDAO.class);
        helper.setUpStudentTable();
        helper.printStudentTable(studentDAO.selectAllStudents());

        Student student = new Student();
        student.setAddress("Moscow");
        student.setRoolNo(1);
        Student student1 = new Student();
        student1.setAddress("Moscow");
        student1.setRoolNo(2);
        Student student2 = new Student();
        student2.setAddress("Moscow");
        student2.setRoolNo(3);

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);

        studentDAO.updateStudent(studentList);
        helper.printStudentTable(studentDAO.selectAllStudents());

        studentDAO.cleanUp();
    }
}

package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DAOConfig.class);
        JDBCDAO test = ctx.getBean("test", JDBCDAO.class);
        test.meta_info();
        test.selectAll();
        System.out.println("--------------------------------------");
        //test.Select("jon", "paster", "paster.jon@gmai.com", "proger", 1000000.00);
        test.selectAll();
        System.out.println("--------------------------------------");
        //test.Updating("DEPARTMENT='HR'", "ID=14");
        test.selectAll();
        System.out.println("--------------------------------------");
        //test.Delete("ID=14");
        test.selectAll();
        System.out.println("--------------------------------------");
        test.SearchToSalary(80000.00, "Legal");
        System.out.println("--------------------------------------");
        //test.TransactionTest();
        test.selectAll();
        System.out.println("--------------------------------------");
        test.MetaDate();
    }
}

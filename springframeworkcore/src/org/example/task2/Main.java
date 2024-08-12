package org.example.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-task2.xml");
        JDBCConnection con = ctx.getBean("jdbcconnection", JDBCConnection.class);
        con.getJDBCConnection();
        System.out.println(con);
    }



}

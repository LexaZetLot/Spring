package org.example.task3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] argv) throws SQLException, ClassNotFoundException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-task3.xml");
        ctx.registerShutdownHook();
        JDBCConnection connect = ctx.getBean("jdbcconnection", JDBCConnection.class);
        connect.selectAllRows();
    }
}

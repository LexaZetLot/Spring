package org.example.task2;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.driver}")
    private String driver;

    public String toString(){
        return "Url: " + url + ", username: " + username  + ", password: " + password + ", driver: " + driver;
    }

    public void getJDBCConnection() throws Exception{
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("connection successful: " + con);
    }
}

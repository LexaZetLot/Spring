package org.example.task3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

public class JDBCConnection {
    private String driver;
    private String url;
    private String userName;
    private String password;
    private Connection con;

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDriver() {
        return driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }


    public void init() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        con = DriverManager.getConnection(url, userName, password);
    }

    public void delete() {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectAllRows() throws SQLException, ClassNotFoundException {
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM musicdb.HOSTELSTUDENTINFO;");

        while (rs.next()){
            int studentId = rs.getInt(1);
            String studentName = rs.getString(2);
            float hostelFlees = rs.getFloat(3);
            String foodType = rs.getString(4);
            System.out.println(studentId + " " + studentName + " " + hostelFlees + " " + foodType);
        }
    }

    public void deleteStudentRecord(int id) throws ClassNotFoundException, SQLException {
        Statement stmt = con.createStatement();;

        stmt.executeUpdate("delete from musicdb.HOSTELSTUDENTINFO where ID = " + id);
    }
}

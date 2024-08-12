package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.Executor;

@Component
public class JDBCDAO {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.driver}")
    private String driver;

    private Connection con;

    @PostConstruct
    public void Connect() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        this.con = DriverManager.getConnection(url, user, password);
    }

    public void Disconnected() throws SQLException {
        con.close();
    }

    public void selectAll() throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from EMPLOYEES");

        while (rs.next())
            System.out.println(rs.getInt("ID") + " " +
                    rs.getString("LAST_NAME") + " " +
                    rs.getString("FIRST_NAME") + " " +
                    rs.getString("EMAIL") + " " +
                    rs.getString("DEPARTMENT") + " " +
                    rs.getDouble("SALARY"));
    }

    public void Select(String last_name, String first_name, String email, String department, Double salary) throws SQLException {
        Statement stmt = con.createStatement();
        String sql = "insert into EMPLOYEES " + "(LAST_NAME, FIRST_NAME, EMAIL, DEPARTMENT, SALARY)" +
                " value" +
                " (" + "'" + last_name + "'" +
                ", " + "'" + first_name + "'" +
                ", " + "'" + email + "'" +
                ", " + "'" + department + "'" +
                ", " + "'" + salary.toString() + "'" + ")";
        stmt.executeUpdate(sql);
    }

    public void Updating(String set, String where) throws SQLException {
        Statement stmt = con.createStatement();
        String sql = "update EMPLOYEES "
                + "set " + set
                + " where " + where;
        stmt.executeUpdate(sql);
    }

    public void Delete(String where) throws SQLException {
        Statement stmt = con.createStatement();
        String sql = "delete from EMPLOYEES where " + where;
        stmt.executeUpdate(sql);
    }

    public void SearchToSalary(double salary, String department) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("select * from EMPLOYEES where salary > ? and department=?");
        stmt.setDouble(1, salary);
        stmt.setString(2, department);
        ResultSet rs = stmt.executeQuery();

        while (rs.next())
            System.out.println(rs.getInt("ID") + " " +
                    rs.getString("LAST_NAME") + " " +
                    rs.getString("FIRST_NAME") + " " +
                    rs.getString("EMAIL") + " " +
                    rs.getString("DEPARTMENT") + " " +
                    rs.getDouble("SALARY"));
    }

    public void TransactionTest() throws SQLException {
        con.setAutoCommit(false);

        Statement stmt = con.createStatement();
        stmt.executeUpdate("delete from EMPLOYEES where department='HR'");
        stmt.executeUpdate("update EMPLOYEES set salary=300000 where department='Engineering'");

        boolean ok = askUserIfOkToSave();
        if(ok)
            con.commit();
        else
            con.rollback();
    }

    public void MetaDate() throws SQLException {
        DatabaseMetaData databaseMetaData = con.getMetaData();
        System.out.println("Product name: " + databaseMetaData.getDatabaseProductName());
        System.out.println("Product version: " + databaseMetaData.getDatabaseProductVersion());
        System.out.println("JDBC Driver name: " + databaseMetaData.getDriverName());
        System.out.println("JDBC Driver version: " + databaseMetaData.getDriverVersion());
    }

    public void meta_info(){
        System.out.println("URL = " + url + "\n" +
                "User = " + user + "\n" +
                "Password = " + password + "\n" +
                "driver = " + driver + "\n" +
                "Connection = " + con);
    }
    private static boolean askUserIfOkToSave() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Is it okay to save?  yes/no: ");
        String input = scanner.nextLine();

        scanner.close();

        return input.equalsIgnoreCase("yes");
    }

}

package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookCartDbUtil {
    private static String url = "jdbc:mysql://172.17.0.2:3306/db_jdbc";
    private static String userName = "user";
    private static String password = "password";
    private static String driver = "com.mysql.cj.jdbc.Driver";

    public static List<Book> getBookList() throws ClassNotFoundException, SQLException {
        ArrayList<Book> book = new ArrayList<Book>();
        Class.forName(driver);

        Connection con = DriverManager.getConnection(url, userName, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from EMPLOYEES");

        while(rs.next()){
            int id = rs.getInt(1);
            String item = rs.getString(2);
            float price = rs.getFloat(3);
            Book buf = new Book(id, item, price);
            book.add(buf);
        }

        return book;
    }
}

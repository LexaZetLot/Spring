package org.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/BookCart")
public class BookServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            List<Book> bookItems = BookCartDbUtil.getBookList();
            request.setAttribute("bookItems", bookItems);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("show-book.jsp");
        dispatcher.forward(request, response);
    }
}

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student List</title>
    </head>
    <body>
        <div align="center">
            <table border="1">
                <thead>
                    <tr>
                        <td>id</td>
                        <td>name</td>
                        <td>mobile</td>
                        <td>country</td>
                    </tr>
                </thead>
                <c:forEach var="student" items="${studentList}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.mobile}</td>
                        <td>${student.country}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>

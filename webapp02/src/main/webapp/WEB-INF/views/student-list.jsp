<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student List</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/my-style-sheet.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/add-students.css">
    </head>
    <body class="myFonts">
        <div class="container">
            <h1 align="center">Student Management</h1>

            <form action="showAddStudentPage">
                <input type="submit" value="ADD" class="btn btn-primary">
            </form><br/>

            <table border="1" class="table table-dark ">
                <thead>
                    <tr>
                        <td>Id</td>
                        <td>Name</td>
                        <td>Mobile</td>
                        <td>Country</td>
                        <td>Update</td>
                        <td>Delete</td>
                    </tr>
                </thead>
                <c:forEach var="student" items="${studentList}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.mobile}</td>
                        <td>${student.country}</td>
                        <td><a href="${pageContext.request.contextPath}/updateStudent?userId=${student.id}">Update</a></td>
                        <td><a href="${pageContext.request.contextPath}/deleteStudent?userId=${student.id}" onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>

            <img alt="fake students photo" src="${pageContext.request.contextPath}/images/img.png">
        </div>
    </body>
</html>

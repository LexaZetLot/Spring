<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/my-style-sheet.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheet/add-students.css">
    </head>
    <body class="">
        <div align="center">
            <h3>Add Student</h3>
            <form:form action="save-student" modelAttribute="student" method="post">
                <form:hidden path="id"/>
                <label>Name: </label>
                <form:input path="name"/><br/>
                <label>Mobile: </label>
                <form:input path="mobile"/><br/>
                <label>Country: </label>
                <form:input path="country"/><br/>

                <input type="submit" value="Submit">
            </form:form>
        </div>
    </body>
</html>

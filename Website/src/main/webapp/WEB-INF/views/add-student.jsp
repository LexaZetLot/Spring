<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
    </head>
    <body>
        <div align="center">
            <h3>Add Student</h3>
            <form:form action="save-student" modelAttribute="student" method="get">
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

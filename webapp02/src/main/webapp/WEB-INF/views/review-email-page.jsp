<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Review</title>
    </head>
    <body>
    <form:form action="/process-email" method="get">
        <label>Enter your Email</label>
        <form:input path="review"/>
        <input type="submit" value="send">
    </form:form>
    </body>
</html>

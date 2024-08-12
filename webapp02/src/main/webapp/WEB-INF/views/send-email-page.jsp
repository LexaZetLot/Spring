<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send Email</title>
    </head>
    <body>
        <h1> Hi ${userInfoDTO.userName}</h1>
        <h2>Send Result To your email</h2>
        <form:form action="/process-email" method="get" modelAttribute="emailDTO">
            <label>Enter your Email</label>
            <form:input path="userEmail"/>
            <input type="submit" value="send">
        </form:form>
    </body>
</html>

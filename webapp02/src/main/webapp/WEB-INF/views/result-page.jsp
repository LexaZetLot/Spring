<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
    </head>
    <body>
        <h1 align="center">Love calculator</h1><hr/>
        <h2>The Love Calculator Predicts</h2>
        ${userInfoDTO.userName} and ${userInfoDTO.crushName}<br/>
        ${userInfoDTO.result}<br/>
        <a href="<c:url value = "${pageContext.request.contextPath}/sendEmail"/>">Send Result to Your Email</a>
    </body>
</html>

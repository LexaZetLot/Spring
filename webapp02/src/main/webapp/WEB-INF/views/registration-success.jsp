<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register success</title>
    </head>
    <body>
        <h1>Your registration is successful</h1>
        <h2>The details entered by you are: </h2>
        User: ${registrationDTO.name}<br/>
        User Name: ${registrationDTO.userName}<br/>
        Password: ${registrationDTO.password}<br/>
        Country: ${registrationDTO.countryName}<br/>
        Hobby: 
            <c:forEach var="temp" items="${registrationDTO.hobbies}">
                ${temp}
            </c:forEach><br/>
        Gender: ${registrationDTO.gender}<br/>
        Age: ${registrationDTO.age}<br/>
        Email: ${registrationDTO.communicationDTO.email}<br/>
        Phone: ${registrationDTO.communicationDTO.phone}
    </body>
</html>

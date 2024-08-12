<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <style type="text/css">
            .error{
                color: red;
                position: fixed;
                text-align: left;
                margin-left: 30px;
            }
        </style>
    </head>
    <body>
        <h1 align="center">Please register here</h1>
        <form:form action="registeration-sucess" method="get" modelAttribute="registrationDTO">
            <div align="center">
                <label>User: </label>
                <form:input path="name"/>
                <form:errors path="name" cssClass="error"/><br/>

                <label>User Name: </label>
                <form:input path="userName"/>
                <form:errors path="userName" cssClass="error"/><br/>

                <label>Password: </label>
                <form:password path="password"/><br/>

                <label>Country: </label>
                <form:select path="countryName">
                    <form:option value="Russia" label="Russia"/>
                    <form:option value="USA" label="USA"/>
                    <form:option value="Canada" label="Canada"/>
                    <form:option value="China" label="China"/>
                </form:select><br/>

                <label>Hobbies: </label>
                Cricket: <form:checkbox path="hobbies" value="Cricket"/>
                Reading: <form:checkbox path="hobbies" value="Reading"/>
                Travel: <form:checkbox path="hobbies" value="Travel"/>
                Programming: <form:checkbox path="hobbies" value="Programming"/><br/>

                <label>Gender: </label>
                Male<form:radiobutton path="gender" value="Male"/>
                Female<form:radiobutton path="gender" value="Female"/><br/>

                <label>Age: </label>
                <form:input path="age"/>
                <form:errors path="age" cssClass="error"/><br/>
            </div>
            <div align="center">
                <h3>Communication</h3>
                <label>Email: </label>
                <form:input path="communicationDTO.email"/>
                <form:errors path="communicationDTO.email" cssClass="error"/><br/>
                <label>Phone: </label>
                <form:input path="communicationDTO.phone"/>
                <form:errors path="communicationDTO" cssClass="error"/><br/>
            </div>
            <div align="center">
                <input type="submit" value="register"/>
            </div>
        </form:form>


    </body>
</html>

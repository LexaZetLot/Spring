<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
        <style type="text/css">
            .error{
                color: red;
                position: fixed;
                text-align: left;
                margin-left: 30px;
            }
        </style>
        <script type="text/javascript">
            function validateUserName(){
                var userName = document.getElementById('yn').value;
                if(userName.length < 2) {
                    alert("your name should have atleast one char")
                    return false;
                }else{
                    return true;
                }
            }
        </script>
    </head>
    <body>
        <h1 align="center">Hi</h1>
        <hr/>
        <form:form action="process-homepage" method="get" modelAttribute="userInfoDTO" onsubmit="return validateUserName()">
            <div align="center">
                <p>
                    <label for="yn">Your name: </label>
                    <form:input type="text" id="yn" path="userName"/>
                    <form:errors path="userName" cssClass="error"/>
                </p>
                <p>
                    <label for="cn">Crush name: </label>
                    <form:input type="text" id="cn" path="crushName"/>
                </p>
                <p>
                    <form:checkbox path="termAndConditon" id="chexk"/>
                    <label>I am agreeing that this is for fun</label>
                    <form:errors path="termAndConditon" cssClass="error"/>
                </p>
                <input type="submit" value="calculate">
            </div>
        </form:form>
    </body>
</html>

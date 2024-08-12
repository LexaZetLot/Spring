<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment</title>
    </head>
    <body>
        <h1 align="center">BILL</h1>

        <form:form action="payment-result" method="get" modelAttribute="paymentDTO">
            <div align="center">
                <label>Card Number: </label>
                <form:input path="numberCard"/><br/>
                <label>Amount: </label>
                <form:input path="currencyType"/>
            </div>
            <div align="center">
                <input type="submit" value="Bill"/>
            </div>
        </form:form>
    </body>
</html>

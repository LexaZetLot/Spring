<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <h1 align="center">Menu</h1>
        <table border="1" cellpadding="30%" align="center" bgcolor="red">
            <tr>
                <th>Code</th>
                <th>Item</th>
                <th>Price</th>
            </tr>
            <c:forEach var="items" items="${bookItems}">
                <tr>
                    <tb>${items.id}</tb>
                    <tb>${items.item}</tb>
                    <tb>${items.price}</tb>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
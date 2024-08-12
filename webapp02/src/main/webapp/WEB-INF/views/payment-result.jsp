<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment result</title>
    </head>
    <body>
        Card Number: ${paymentDTO.numberCard}<br/>
        Amount: ${paymentDTO.currencyType}<br/>
    </body>
</html>

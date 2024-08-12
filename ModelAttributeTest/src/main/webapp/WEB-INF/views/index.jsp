<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Info</title>
    </head>
    <body>
        <h1 align="center">Using @ModelAttribute Method Level: How, Why, When</h1>
        <hr/>

        Website Name: ${websiteInfoDTO.websiteName}<br/>
        Website Category: ${websiteInfoDTO.websiteCategory}<br/>
        Website header: ${headerModel}
    </body>
</html>

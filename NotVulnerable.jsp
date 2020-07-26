<%--
  Created by IntelliJ IDEA.
  User: aviv
  Date: 25/07/2020
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Website login</title>
</head>
<body>
<div style="text-align: center">
    <h1>Login Website - Not Vulnerable SQLi</h1>
    <form action="notVulnerableLogin" method="post">
        <label for="Username">Username:</label>
        <input name="Username" size="30" />
        <br><br>
        <label for="password">Password:</label>
        <input type="password" name="password" size="30" />
        <br>${message}
        <br><br>
        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>
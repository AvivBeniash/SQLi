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
  <title>SQL Injection test</title>
</head>
<body>
<div style="text-align: center">
  <h1>SQL Injection test</h1>
  <form action="NotVulnerable.jsp" method="GET">
    <button type="submit">Not vulnerable</button>
  </form>
  <form action="VulnerableForm.jsp" method="GET">
    <button type="submit">Vulnerable</button>
  </form>
</div>
</body>
</html>
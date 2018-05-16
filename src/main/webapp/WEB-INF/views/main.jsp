<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 15.05.18
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>Главная страница</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
<ul>
    <li><a href="/" class="menu">Главная</a></li>
    <li><a href="/login" class="menu">Вход</a></li>
    <li><a href="#" class="menu">Регистрация</a></li>
</ul>
</body>
</html>

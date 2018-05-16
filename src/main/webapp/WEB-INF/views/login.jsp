<%--
  Created by IntelliJ IDEA.
  User: anatoliy
  Date: 15.05.18
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Авторизация</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
<ul>
    <li><a href="/" class="menu">Главная</a></li>
    <li><a href="/login" class="menu">Вход</a></li>
    <li><a href="#" class="menu">Регистрация</a></li>
</ul>
<div class="login-page">
    <div class="form">
    <form name="loginForm" action="j_spring_security_check"  method="post" class="login-form">
        <p><c:if test="${not empty error}">${error}</c:if></p>
        <input type="text" name="username" placeholder="Логин"/>
        <input type="password" name="password" placeholder="Пароль">
        <button type="submit">Войти</button>
    </form>
    </div>
</div>
</body>
</html>

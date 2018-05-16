<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 16.05.18
  Time: 7:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>Добавить питомца</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
<div class="login-page">
    <div class="form">
<spring:url value="/savepet" var="saveURL"/>
<form:form action="${saveURL}" modelAttribute="petForm" method="POST">
    <form:hidden path="id"/>
    <form:input path="owner" placeholder="Владелец"/>
    <form:input path="number" placeholder="Телефон"/>
    <form:input path="address" placeholder="Адрес"/>
    <form:input path="city" placeholder="Город"/>
    <form:input path="country" placeholder="Страна"/>
    <form:input path="petname" placeholder="Кличка"/>
    <form:input path="species" placeholder="Вид"/>
    <form:input path="breed" placeholder="Порода"/>
    <form:input path="gender" placeholder="Пол"/>
    <form:input path="age" placeholder="Возраст"/>
    <sec:authorize access="hasRole('ADMIN')">
    <button type="submit">Изменить</button>
    </sec:authorize>
    <sec:authorize access="hasRole('STAFF')">
        <button type="submit">Изменить</button>
    </sec:authorize>
    <sec:authorize access="hasRole('USER')">
        <button type="submit">Добавить</button>
    </sec:authorize>
</form:form>
    </div>
</div>
</body>
</html>

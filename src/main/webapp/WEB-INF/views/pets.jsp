<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 16.05.18
  Time: 7:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>Список питомцев</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
<ul>
    <li><a href="<c:url value="/logout"/> " class="menu">Выйти</a></li>
</ul>
<div class="well">
    <p>Добро пожаловать, ${pageContext.request.userPrincipal.name}!</p>
    <sec:authorize access="hasRole('ADMIN')">
    <p>Вы вошли в систему в качестве администратора!</p>
    </sec:authorize>
    <sec:authorize access="hasRole('STAFF')">
        <p>Вы вошли в систему в качестве сотрудника!</p>
    </sec:authorize>
    <sec:authorize access="hasRole('USER')">
        <p>Вы вошли в систему в качестве клиента!</p>
        <spring:url value="/addpet" var="addURL"/>
        <a class="add-pet" href="${addURL}">Добавить питомца</a>
    </sec:authorize>
</div>
<table class="tab">
    <thead style="padding-bottom: 20px;">
    <tr>
        <th>Владелец</th>
        <th>Телефон</th>
        <th>Адрес</th>
        <th>Город</th>
        <th>Страна</th>
        <th>Кличка</th>
        <th>Тип</th>
        <th>Порода</th>
        <th>Пол</th>
        <th>Вораст</th>
        <th colspan="2">Действие</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listPet}" var="pet">
        <tr>
            <td>${pet.owner}</td>
            <td>${pet.number}</td>
            <td>${pet.address}</td>
            <td>${pet.city}</td>
            <td>${pet.country}</td>
            <td>${pet.petname}</td>
            <td>${pet.species}</td>
            <td>${pet.breed}</td>
            <td>${pet.gender}</td>
            <td>${pet.age}</td>
            <td>
                <sec:authorize access="hasRole('ADMIN')">
                <spring:url value="/updatepet/${pet.id}" var="updateURL"/>
                <a href="${updateURL}">Изменить</a>
                </sec:authorize>
                <sec:authorize access="hasRole('STAFF')">
                    <spring:url value="/updatepet/${pet.id}" var="updateURL"/>
                    <a href="${updateURL}">Изменить</a>
                </sec:authorize>
                <sec:authorize access="hasRole('USER')">
                    Изменение недоступно!
                </sec:authorize>
            </td>
            <td>
                <sec:authorize access="hasRole('ADMIN')">
                <spring:url value="/deletepet/${pet.id}" var="deleteURL"/>
                <a href="${deleteURL}">Удалить</a>
                </sec:authorize>
                <sec:authorize access="hasRole('STAFF')">
                    <spring:url value="/deletepet/${pet.id}" var="deleteURL"/>
                    Удаление недоступно!
                </sec:authorize>
                <sec:authorize access="hasRole('USER')">
                    <spring:url value="/deletepet/${pet.id}" var="deleteURL"/>
                    Удаление недоступно!
                </sec:authorize>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

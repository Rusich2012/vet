<%--
  Created by IntelliJ IDEA.
  User: anatoliy
  Date: 27.04.18
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>Examole</title>
</head>
<body>
<spring:url value="/add" var="addURL"/>
<a href="${addURL}">Add example></a>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listExample}" var="example">
            <tr>
                <td>${example.name}</td>
                <td>
                    <spring:url value="/update/${example.id}" var="updateURL"/>
                    <a href="${updateURL}">Update</a>
                </td>
                <td>
                    <spring:url value="/delete/${example.id}" var="deleteURL"/>
                    <a href="${deleteURL}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>

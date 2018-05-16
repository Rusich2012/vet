<%--
  Created by IntelliJ IDEA.
  User: anatoliy
  Date: 27.04.18
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>Form</title>
</head>
<body>

<spring:url value="/save" var="saveURL"/>
<form:form action="${saveURL}" modelAttribute="exampleForm" method="POST">
    <form:hidden path="id"/>
    <label>Name:</label>
    <form:input path="name"/><br/>
    <button type="submit">Save</button>
</form:form>

</body>
</html>

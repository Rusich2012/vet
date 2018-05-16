<%--
  Created by IntelliJ IDEA.
  User: anatoliy
  Date: 15.05.18
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>User</title>
</head>
<body>
    <p>
        Welcome ${pageContext.request.userPrincipal.name}!
        <a href="<c:url value="/logout"/> ">Logout</a>
    </p>

    <table>
        <thead>
            <tr>
                <th>#ID</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${usersList}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>
                        <sec:authorize access="hasRole('ADMIN')">
                            <a href="#">Update</a>
                            <a href="#">Delete</a>
                        </sec:authorize>
                        <sec:authorize access="hasRole('STAFF')">
                            <a href="#">Update</a>
                        </sec:authorize>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

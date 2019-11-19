<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title> List Users </title>
</head>
<body>
<h1> List Users</h1>

<table>
    <tr>
        <th>id</th>
        <th>userName</th>
        <th>role</th>
        <th>actions</th>
    </tr>
    <c:forEach var="users" items="${users}">
        <tr>
            <td>${users.id}</td>
            <td>${users.username}</td>
            <td>${users.roles}</td>
            <td>
                <a href="/user/${users.id}">edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:url value="/home" var="home"/>
<a href="${home}">Return to Home</a>

</body>
</html>
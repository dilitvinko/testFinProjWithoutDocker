<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title> Main </title>
</head>
<body>

<div>
    <h2>People</h2>
    <table>
        <tr>
            <th>id</th>
            <th>lastName</th>
            <th>firstName</th>
            <th>patronymic</th>
            <th>login</th>
            <th>password</th>
            <th>actions</th>
        </tr>
        <c:forEach var="people" items="${peopleList}">
            <tr>
                <td>${people.id}</td>
                <td>${people.lastName}</td>
                <td>${people.firstName}</td>
                <td>${people.patronymic}</td>
                <td>${people.login}</td>
                <td>${people.password}</td>
                <td>
                    <a href="/edit/${people.id}">edit</a>
                    <a href="/delete/${people.id}">delete</a>
                    <a href="/tasks/${people.id}">tasks</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <c:url value="/add" var="add"/>
    <a href="${add}">Add new people</a>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <c:if test="${empty people.lastName}">
        <title>Add People</title>
    </c:if>
    <c:if test="${!empty people.lastName}">
        <title>Edit People</title>
    </c:if>
</head>
<body>
<div class="container">
    <c:if test="${empty people.lastName}">
        <c:url value="/add" var="var"/>
        <h2><span>Add People</span></h2>
    </c:if>
    <c:if test="${!empty people.lastName}">
        <c:url value="/edit/${people.id}" var="var"/>
        <h2> Edit People id = ${people.id} </h2>
    </c:if>


    <form action="${var}" method="post">
        <c:if test="${!empty people.lastName}">
            <input type="hidden" name="id" value="${people.id}">
        </c:if>
        <label for="lastName">lastName</label>
        <input type="text" name="lastName" id="lastName">
        <label for="firstName">firstName</label>
        <input type="text" name="firstName" id="firstName">
        <label for="patronymic">patronymic</label>
        <input type="text" name="patronymic" id="patronymic">
        <label for="login">login</label>
        <input type="text" name="login" id="login">
        <label for="password">password</label>
        <input type="text" name="password" id="password">
        <c:if test="${empty people.lastName}">
            <input type="submit" value="Add new people">
        </c:if>
        <c:if test="${!empty people.lastName}">
            <input type="submit" value="Edit people">
        </c:if>
        <br>
    </form>
    <c:url value="/allPeople" var="main"/>
    <a href="${main}">Return People Page</a>
</div>
</body>
</html>
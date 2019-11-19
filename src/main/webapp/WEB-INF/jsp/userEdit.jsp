<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Edit user id = ${user.id}</title>
</head>
<body>

<%--<c:if test="${role == "USER"}">--%>
<%--    <c:url value="/add" var="var"/>--%>
<%--</c:if>--%>
<%--<c:if test="${!empty people.lastName}">--%>
<%--    <c:url value="/edit/${people.id}" var="var"/>--%>
<%--</c:if>--%>

<div class="container">
    <h2> Edit user id = ${user.id} </h2>
    <form action="/user" method="post">
        <input type="text" name="username" value="${user.username}">
        <c:forEach var="role" items="${roles}">
            <c:if test="${fn:contains({user.roles}, role)}">
                    <label><input type="checkbox" name="${role}" checked>${role}</label>
            </c:if>
            <c:if test="${! fn:contains({user.roles}, role)}">
                    <label><input type="checkbox" name="${role}">${role}</label>
            </c:if>
        </c:forEach>
        <input type="hidden" value="${user.id}" name="userId">
        <button type="submit">Save</button>
    </form>
    <c:url value="/user" var="user"/>
    <a href="${user}">Return to Users</a>
</div>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Add Log for Task id = ${task.id}</title>
</head>
<body>

<c:url value="/tasks/${people.id}/task/${task.id}/addLog" var="var"/>

<div class="container">
    <h2> Add Log for Task id = ${task.id} </h2>
    <form action="${var}" method="post">
        <label for="time">time</label>
        <input type="number" name="time" id="time">
        <label for="comment">comment</label>
        <input type="text" name="comment" id="comment">
        <input type="submit" value="Add new log">
    </form>
    <c:url value="/tasks/${people.id}/logs/${task.id}" var="logsPage"/>
    <a href="${logsPage}">Return Logs's Page</a>
</div>

</body>
</html>
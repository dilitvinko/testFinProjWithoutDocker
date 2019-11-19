<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <c:if test="${empty task.nameTask}">
        <title>Add Task for People id = ${people.id}</title>
    </c:if>
    <c:if test="${!empty task.nameTask}">
        <title>Edit task id=${task.id} </title>
    </c:if>
</head>
<body>
<div class="container">
    <c:if test="${empty task.nameTask}">
        <c:url value="/tasks/${people.id}/addTask" var="var"/>
        <h2> Add Task for People id = ${people.id} </h2>
    </c:if>
    <c:if test="${!empty task.nameTask}">
        <c:url value="/tasks/${people.id}/edit/${task.id}" var="var"/>
        <h2> Edit Task id = ${task.id} </h2>
    </c:if>


    <form action="${var}" method="post">
        <c:if test="${!empty task.nameTask}">
            <input type="hidden" name="id" value="${task.id}">
        </c:if>
        <label for="nameTask">nameTask</label>
        <input type="text" name="nameTask" id="nameTask">

        <label for="state">state</label>
        <select name="state" id="state">
            <option value="true">true (completed)</option>
            <option value="false">false (not completed)</option>
        </select>

        <c:if test="${empty task.nameTask}">
            <input type="submit" value="Add new task">
        </c:if>
        <c:if test="${!empty task.nameTask}">
            <input type="submit" value="Edit task">
        </c:if>
        <br>
    </form>
    <c:url value="/tasks/${people.id}" var="tasksPage"/>
    <a href="${tasksPage}">Return Task's Page</a>
</div>
</body>
</html>
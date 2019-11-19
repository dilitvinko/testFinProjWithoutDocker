<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title> Tasks of People with id ${people.id}</title>
</head>
<body>

<div>
    <h2>Tasks of People with id=${people.id}</h2>
    <table>
        <tr>
            <th>id</th>
            <th>nameTask</th>
            <th>state</th>
            <th>actions</th>
        </tr>
        <c:forEach var="task" items="${taskList}">
            <tr>
                <td>${task.id}</td>
                <td>${task.nameTask}</td>
                <td>${task.state}</td>
                <td>
                    <a href="/tasks/${people.id}/edit/${task.id}">edit</a>
                    <a href="/tasks/${people.id}/logs/${task.id}">logs</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <c:url value="/tasks/${people.id}/addTask" var="addTask"/>
    <a href="${addTask}">Add new Task</a>
    <br>
    <c:url value="/allPeople" var="main"/>
    <a href="${main}">Return People Page</a>
</div>
</body>
</html>
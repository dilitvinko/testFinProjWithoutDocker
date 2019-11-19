<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title> Logs of Task with id ${task.id}</title>
</head>
<body>

<div>
    <h2>Logs of Task with id=${task.id}</h2>
    <table>
        <tr>
            <th>id</th>
            <th>time</th>
            <th>comment</th>
        </tr>
        <c:forEach var="log" items="${logList}">
            <tr>
                <td>${log.id}</td>
                <td>${log.time}</td>
                <td>${log.comment}</td>

            </tr>
        </c:forEach>
    </table>

    <br>
    <c:url value="/tasks/${people.id}/task/${task.id}/addLog" var="addLog"/>
    <a href="${addLog}">Add new Log</a>
    <br>
    <c:url value="/tasks/${people.id}" var="tasksPage"/>
    <a href="${tasksPage}">Return Task's Page</a>
</div>
</body>
</html>
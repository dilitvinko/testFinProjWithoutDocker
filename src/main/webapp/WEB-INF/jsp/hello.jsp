<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Hello World!</title>
    <script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"
            async defer>
    </script>
</head>
<body>
<h1 inlist="text">Hello ${httpServletRequest.remoteUser}!</h1>
<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>
<form action="/allPeople" method="get">
    <input type="submit" value="Watch All People"/>
</form>
<form action="/user" method="get">
    <input type="submit" value="Watch Users, Admins"/>
</form>
</body>
</html>
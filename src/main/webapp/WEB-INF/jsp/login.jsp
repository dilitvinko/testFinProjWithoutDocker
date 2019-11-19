<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Boot Security- Change default login page</title>
    <script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body>
<h1>Login page</h1>

<form action="login" method="post">
    <table>
        <tr style="color: red;">
            <td></td>
            <td>${SPRING_SECURITY_LAST_EXCEPTION.message}</td>
        </tr>
        <tr>
            <td>User name:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"></td>

        </tr>
        <tr>
            <td></td>

        </tr>
        <tr>

            <td><input type="submit" value="Login"></td>
        </tr>
    </table>

</form>
<a href="/registration">Add new user</a>
</body>
</html>
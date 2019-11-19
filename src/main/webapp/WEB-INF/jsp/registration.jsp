<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Boot Security- Change default login page</title>
    <script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body>
<h1>Add new User</h1>
${message}
<form action="registration" method="post">
    <table>
        <tr style="color: red;">
            <td></td>
            <td>${SPRING_SECURITY_LAST_EXCEPTION.message}</td>
        </tr>
        <tr>
            <td>User name:</td>
            <td><input type="text" name="username" value="${user.username}"></td>
            <td><div style="color: red;">${usernameError}</div></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" value="${user.password}"></td>
            <td><div style="color: red;">${passwordError}</div></td>
        </tr>
        <tr>
            <td></td>
            <td><div class="g-recaptcha" data-sitekey="6LdRT7sUAAAAAL6uEFAFZwD0VbQ297q-cpoP7v9J"></div></td>
        </tr>
        <tr>
            <td><div style="color: red;">${captchaError}</div></td>
            <td><input type="submit" value="Login"></td>
        </tr>
    </table>

</form>
</body>
</html>
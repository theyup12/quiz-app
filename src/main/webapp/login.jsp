<%--
  Created by IntelliJ IDEA.
  User: theyup12
  Date: 2022/6/14
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<div id = "container">
    <form:form action="/user-login" modelAttribute="userLogin" method="post">
    <table>
        <tbody>
            <tr>
                <td><form:label path="email" for="email">Email: </form:label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><form:label path="password" for="password">Password:</form:label></td>
                <td><form:input path="password"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Login" class="login"/></td>
            </tr>
        </tbody>
    </table>
    </form:form>
</div>
    <div>
        <input type="button" value="Register"
               onclick="window.location.href='register-new-user'; return false;"
               class="add-button"/>
    </div>
</body>
</html>

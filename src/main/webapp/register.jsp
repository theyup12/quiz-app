<%--
  Created by IntelliJ IDEA.
  User: theyup12
  Date: 2022/6/14
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Register New User</title>
<%--    <link rel="stylesheet" type=text/css" href="/webjars/bootstrap/css/boostrap.min.css">--%>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Register Page</h2>
        </div>
    </div>
    <div class = "container">
        <form:form action="/registerUser" modelAttribute="user" method="post">
            <table>
                <tbody>
                    <tr>
                        <td><label>First name:</label></td>
                        <td><form:input path="firstName"/></td>
                    </tr>
                    <tr>
                        <td><label>Last name:</label></td>
                        <td><form:input path="lastName"/></td>
                    </tr>
                    <tr>
                        <td><label>Email:</label></td>
                        <td><form:input path="email"/></td>
                    </tr>
                    <tr>
                        <td><label>Phone:</label></td>
                        <td><form:input path="phone"/></td>
                    </tr>
                    <tr>
                        <td><label>Password:</label></td>
                        <td><form:input path="password"/></td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"/></td>
                    </tr>
                </tbody>
            </table>
        </form:form>
        <div>
            <p>
                <a href="${pageContext.request.contextPath}/">Back to Login</a>
            </p>
        </div>
    </div>
</body>
</html>

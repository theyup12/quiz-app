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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%@include file="nav.jsp"%>
    <div class = "container mt-5">
        <div class="text-center">
            <h2>Register Page</h2>
        </div>
        <form:form action="/registerUser" modelAttribute="user" method="post">
            <div class="form-group">
                <label for="InputFirstName">First name:</label>
                <form:input id="InputFirstName" type="text" class="form-control"
                            path="firstName" placeholder="Enter First Name" required="required"/>
                <form:errors path="firstName" style="color:red;"/>
            </div>
            <div class="form-group">
                <label for="InputLastName">Last name:</label>
                <form:input id="InputLastName" type="text" class="form-control"
                            path="lastName" placeholder="Enter Last Name" required="required"/>
                <form:errors path="lastName" style="color:red;"/>
            </div>
            <div class="form-group">
                <label for="InputEmail">Email:</label>
                <form:input id="InputEmail" type="email" class="form-control"
                            path="email" placeholder="Enter Email" required="required"/>
                <form:errors path="email" style="color:red;"/>
            </div>
            <div class="form-group">
                <label for="InputPhone">Phone:</label>
                <form:input id="InputPhone" type="phone" class="form-control"
                            path="phone" placeholder="Enter Phone" required="required"/>
                <form:errors path="phone" style="color:red;"/>
            </div>
            <div class="form-group">
                <label for="InputPassword">Password:</label>
                <form:input id="InputPassword" type="password" class="form-control"
                            path="password" placeholder="Enter Password" required="required"/>
                <form:errors path="password" style="color:red;"/>
            </div>
            <input class="btn btn-primary" type="submit" value="Create Account" class="save"/>

        </form:form>
        <div>
            <p>
                Already have an account? <a href="${pageContext.request.contextPath}/">Log in</a>
            </p>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

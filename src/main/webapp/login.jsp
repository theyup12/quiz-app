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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="text-center ">
    <h2>Sign In</h2>
</div>
<div class = "container">
    <form:form action="/user-login" modelAttribute="userLogin" method="post" style="max-width:480px;margin:auto">
        <div class="form-group">
            <form:label for="InputEmail" path="email">Email: </form:label>
            <form:input id="InputEmail" type="email" class="form-control"
                        path="email" placeholder="Enter Email" required="required"/>
            <form:errors path="email" style="color:red"/>
        </div class="form-group">
        <div>
            <form:label for="InputPassword" path="password" >Password:</form:label>
            <form:input id="InputPassword" type="password" class="form-control"
                        path="password" placeholder="Enter Password" required="required"/>
            <form:errors path="password" stle="color:red"/>
        </div>
        <div class="mt-3">
            <button class="btn btn-primary btn-lg btn-block" type="submit" value="Login" class="login">Sign In</button>
        </div>
        <div class="mt-3">
            <a class="btn btn-outline-primary btn-lg btn-block"
               role="button" href="${pageContext.request.contextPath}/register-new-user">Regiester</a>
        </div>

    </form:form>
    <div class="text-danger">${error}</div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andycao
  Date: 6/24/22
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Submit</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<c:choose>
    <c:when test="${isExisted}">
        <div class="container mt-5">
            <div class="col-md-12 text-center">
                <h3 class="font-weight-bold">Successfully Created User</h3>
                <p>Your account are created successfully, you can go back login page to sign in</p>
            </div>
            <div class="col-md-12 text-center">
                <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Return to Login</a>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="container mt-5">
            <div class="col-md-12 text-center">
                <h3 class="font-weight-bold">Email existed</h3>
                <p>Please register again with different email</p>
            </div>
            <div class="col-md-12 text-center">
                <a href="${pageContext.request.contextPath}/register-new-user" class="btn btn-primary">Return to Register</a>
            </div>
        </div>
    </c:otherwise>
</c:choose>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: theyup12
  Date: 2022/6/14
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<%@include file="nav.jsp"%>
    <div id="wrapper">
        <div id="header">
            <h2>List of User</h2>
        </div>
    </div>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">User ID</th>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Email</th>
        <th scope="col">Phone</th>
        <th scope="col">Status</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="singleUser" items="${users}" >
        <tr>
            <th scope="row">${singleUser.getUserId()}</th>
            <td>${singleUser.getFirstName()}</td>
            <td>${singleUser.getLastName()}</td>
            <td>${singleUser.getEmail()}</td>
            <td>${singleUser.getPhone()}</td>
            <c:choose>
                <c:when test="${singleUser.getIsActive() != 1}">
                    <td>
                        <form action="${pageContext.request.contextPath}/admin/list-user?userId=${singleUser.getUserId()}" method="post">
                            <button class="btn btn-outline-primary" type="submit" name="status" value="active">Active</button>
                        </form>
                    </td>
                </c:when>
                <c:otherwise>
                    <td>
                        <form action="${pageContext.request.contextPath}/admin/list-user?userId=${singleUser.getUserId()}" method="post">
                            <button class="btn btn-outline-primary" type="submit" name="status" value="suspend">Suspend</button>
                        </form>
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
    </ul>
</nav>
</body>
</html>

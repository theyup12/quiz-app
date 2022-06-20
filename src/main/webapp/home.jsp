<%--
  Created by IntelliJ IDEA.
  User: theyup12
  Date: 2022/6/15
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Category Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<%@include file="nav.jsp"%>
    <div id="header">
        <h2>Categories</h2>
    </div>
    <div class="row">
            <c:forEach var="category" items="${categories}">
            <c:url var="questionsLink" value="/show-questions">
                <c:param name = "categoryId" value="${category.getCategoryId()}"></c:param>
            </c:url>
                <div class="col-sm-4">
                    <div class="card" style="flex: auto">
                        <img src="${pageContext.request.contextPath}/image/${category.getCategoryName()}.png" class="card-img-top" alt="${category.getCategoryName()}">
                            <div class="card-body">
                                <h4 class="card-title">${category.getCategoryName()}</h4>
                                <p>${category.getDescription()}</p>
                                <a href="${questionsLink}" class="btn btn-primary">Start Quiz</a>
                            </div>
                    </div>
                </div>
            </c:forEach>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

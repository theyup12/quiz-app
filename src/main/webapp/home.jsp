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
</head>
<body>
    <div id="wraper">
        <div id="header">
            <h2>Categories</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <table>
                <c:forEach var="category" items="${categories}">
                    <c:url var="questionsLink" value="/questions">
                        <c:param name = "categoryId" value="${category.getCategoryId()}"></c:param>
                    </c:url>
                    <tr>
                        <td>${category.getCategoryName()}</td>
                        <td>${category.getDescription()}</td>
                        <td>${category.getCategoryId()}</td>
                        <td>
                            <a href="${questionsLink}">Start Quiz</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>

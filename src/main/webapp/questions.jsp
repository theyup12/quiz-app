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
    <title>Title</title>
</head>
<body>
<div id="wraper">
    <div id="header">
        <h2>List of Questions</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <table>
            <c:forEach var="tempQuestions" items="${questions}">
                <tr>
                    <td>${tempQuestions.getContent()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

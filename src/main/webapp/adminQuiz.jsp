<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dyc
  Date: 7/5/22
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>quiz</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

</head>
<body>
<br/>
<h4>All Users History Quizzes:</h4>
<div>
    <c:if test="${quizzes.size() != 0}">
        <c:forEach var="s" begin="0" end="${quizzes.size() - 1}">
            <div class="list-group">
                <c:set var = "user" value = "${userList.get(quizzes.get(s).getUser().getUserId()-1)}"/>
                <a href="${pageContext.request.contextPath}/overview-quiz-report?quizId=${quizzes.get(s).getQuizId()}&userId=${quizzes.get(s).getUser().getUserId()}" class="list-group-item list-group-item-action flex-column align-items-start ">
                    <h5 class="mb-1">${user.getFirstName()} ${user.getLastName()}</h5>
                    <div class="d-flex w-100 justify-content-between">
                        <h5 class="mb-1">${categoryList.get(quizzes.get(s).getCategory().getCategoryId()-1).getCategoryName()}</h5>
                        <small>Score: ${quizzes.get(s).getScore()}/10</small>
                    </div>
                    <p class="mb-1">${categoryList.get(quizzes.get(s).getCategory().getCategoryId()-1).getDescription()}</p>
                    <small>${quizzes.get(s).getStartTime()} ~ ${quizzes.get(s).getFinishTime()}</small>
                </a>
            </div>
        </c:forEach>
    </c:if>
</div>


</body>
</html>

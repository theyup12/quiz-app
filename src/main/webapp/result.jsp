<%--
  Created by IntelliJ IDEA.
  User: dyc
  Date: 6/28/22
  Time: 9:16 AM
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
<h4>History Quizzes:</h4>
<div>
    <c:if test="${quizzes.size() != 0}">
        <c:forEach var="s" begin="0" end="${quizzes.size() - 1}">
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/online-quiz/get-quiz-report?quizId=${quizzes.get(s).getQuizId()}" class="list-group-item list-group-item-action flex-column align-items-start ">
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


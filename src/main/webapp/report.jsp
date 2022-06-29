<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>report</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

</head>
<body>
<%@ include file="nav.jsp" %>

<h3 class="text-center">Quiz:${quiz.getCategory().getCategoryName()}</h3>
<h4>${user.getFirstName()} ${user.getLastName()}</h4>
<h5> At:${quiz.getStartTime()} ~ ${quiz.getFinishTime()}</h5>
<h6 class="text-info">${quiz.getScore() >= 6 ? 'Passed':"Not Passed"}</h6>
<hr>
    <c:forEach var="i"  begin="0" end="${questionList.size() - 1}">
        <div class="py-2 h5">
            <b>${quizResultList.get(i).getOrder() + 1}. ${questionList.get(i).getContent()}</b>
        </div>
        <c:forEach var="choice" items="${questionList.get(i).getChoices()}">
            <div class="ml-md-3 ml-sm-5 pl-md-3 pl-md-5 pt-sm-2 pt-3">
                <c:choose>
                    <c:when test="${choice.getChoiceId() == quizResultList.get(i).getCorrectChoice()}">
                        <span class="text-white bg-success">${choice.getContents()}</span>
                    </c:when>
                    <c:when test="${choice.getChoiceId() == quizResultList.get(i).getUserChoice()}">
                        <span class="text-white bg-danger">${choice.getContents()}</span>
                    </c:when>
                    <c:otherwise>
                        ${choice.getContents()}
                    </c:otherwise>
                </c:choose>
            </div>
        </c:forEach>
        <hr>
    </c:forEach>
</body>
</html>


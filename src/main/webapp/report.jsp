<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>report</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

</head>
<body>
<%@ include file="nav.jsp" %>

<h3>Quiz:${quiz.getCategory().getCategoryName()}</h3>
<h4>${user.getFirstName()} ${user.getLastName()}</h4>
<h5> At:${quiz.getStartTime()} ~ ${quiz.getFinishTime()}</h5>
<h6 class="text-info">${quiz.getScore() >= 6 ? 'Passed':"Not Passed"}</h6>

<c:forEach var="i"  begin="0" end="${questionList.size() - 1}">
    <div class="py-2 h5">
        <b>${quizResultList.get(i).getOrder() + 1}. ${questionList.get(i).getContent()}</b>
    </div>
    <c:forEach var="choice" items="${questionList.get(i).getChoices()}">
        <div class="ml-md-3 ml-sm-3 pl-md-3 pl-md-5 pt-sm-0 pt-3">
            ${choice.getContents()}
            <c:if test="${choice.getChoiceId() ==quizResultList.get(i).getUserChoice()}">
                <span class="text-danger">Your Answer</span>
            </c:if>
            <c:if test="${choice.getChoiceId() == quizResultList.get(i).getCorrectChoice()}">
                <span class="text-success">Correct Answer</span>
            </c:if>
        </div>
    </c:forEach>
</c:forEach>
</body>
</html>


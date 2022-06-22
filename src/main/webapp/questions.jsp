
<%--
  Created by IntelliJ IDEA.
  User: theyup12
  Date: 2022/6/14
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div id="wraper">
    <div id="header">
        <h2>List of Questions</h2>
    </div>
</div>
<form action="${pageContext.request.contextPath}/quiz?index=${index}" method="post">
    <div id="container">
        <div class="btn-group" role="group">
            <c:forEach begin="0" end="9" varStatus="loop">
                <button type="sumbit" class="btn btn-secondary" value="${loop.index}" name="action">
                        ${loop.index + 1}
                </button>
            </c:forEach>
        </div>
        <table>
            <tr>
                <td>${index + 1}. ${questionsList.get(index).getContent()}</td>
            </tr>
            <tr>
                <c:forEach var="choice" items="${questionsList.get(index).getChoices()}">
                    <td>
                        <input type="radio" name="input" value="${choice.getChoiceId()}">
                        <lable>${choice.getContents()}</lable>
                    </td>
                </c:forEach>
            </tr>
        </table>
    </div>
</form>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>

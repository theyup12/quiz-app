<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: andycao
  Date: 6/20/22
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<%@include file="nav.jsp"%>
<div class="container mt-5">
    <h1>Give Feedback For the Quiz</h1>
    <c:form class="row g-2" action="/online-quiz/feedback" modelAttribute="feedback" method="post">
        <div class="col-md-12">
            <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Preference</label>
            <form:select class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref" path="type">
                <form:option selected="selected" value="">Choose...</form:option>
                <form:option value="JAVA">Java</form:option>
                <form:option value="SPRING">Spring</form:option>
                <form:option value="OOP">OOP</form:option>
            </form:select>
        </div>
        <div class="col-md-12">
            <label class="my-1 mr-2" for="rating">Rating</label>
            <form:select class="custom-select my-1 mr-sm-2" id="rating" path="rating">
                <form:option selected="selected" value="">Choose...</form:option>
                <form:option value="1">1 - Extremely Poor</form:option>
                <form:option value="2">2 - Bad</form:option>
                <form:option value="3">3 - Average</form:option>
                <form:option value="4">4 - Good</form:option>
                <form:option value="5">5 - Excellent</form:option>
            </form:select>
        </div>
        <div class="col-md-12">
            <label for="inputMessage" class="form-label">Leave a Message</label>
            <form:textarea id="inputMessage" type="text" class="form-control" path="review" rows="3" placeholder="leave some messages"/>
        </div>
        <div class="col-md-12 mt-3">
            <input type="submit" class="btn btn-primary" value="Submit"/>
        </div>
    </c:form>
</div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

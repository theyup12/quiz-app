
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
<%@ page session="false" %>
<html>
<head>
    <title>Quiz</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
    <div class="container p-4 my-4 bg-secondary bg-gradient text-white">
        <h1>Welcome to ${category.getCategoryName()} Quiz</h1>
    </div>
    <form action="${pageContext.request.contextPath}/online-quiz/quiz?index=${index}" method="post">
        <div class="row align-items-center">
            <div class="col-6 mx-auto">
                <div class="card shadow border">
                    <div class="card-header">
                        <div class="btn-group" role="group">
                            <c:forEach begin="0" end="9" varStatus="loop">
                                <button type="sumbit" class="btn btn-secondary" value="${loop.index}" name="action">
                                        ${loop.index + 1}
                                </button>
                            </c:forEach>
                        </div>
                        <div class="float-right">
                            <p>${startTime}</p>
                            <p id ="countdown"></p>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="py-2 h5">
                            <b>${index + 1}. ${questionsList.get(index).getContent()}</b>
                        </div>
                            <c:forEach var="choice" items="${questionsList.get(index).getChoices()}">
                                <div class="ml-md-3 ml-sm-3 pl-md-3 pl-md-5 pt-sm-0 pt-3">
                                    <input type="radio" id=c"${choice.getChoiceId()}" name="input" value="${choice.getChoiceId()}"
                                    ${ answerArray[index] == choice.getChoiceId() ? 'checked="checked"' : ''}>
                                    <label for="c${choice.getChoiceId()}">${choice.getContents()}</label>
                                </div>
                            </c:forEach>

                        <button type="submit" class="btn btn-outline-primary btn-md" id = "previous"
                                name="action" value="previous" ${ index < 1 ? 'disabled="disabled"' : ''}>Previous</button>
                        <button type="submit" class="btn btn-outline-primary btn-md" id = "next"
                                name="action" value="next" ${ index > 8 ? 'disabled="disabled"' : ''}>Next</button>

                        <button type="button" class="btn btn-outline-primary float-right" data-toggle="modal" data-target="#exampleModal">Submit Quiz
                        </button>
                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <p>Are you sure you want to submit the quiz?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                                        <button type="submit" class="btn btn-primary" id="submitQ" name="action" value="finish">
                                            Submit
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <script src="js/countdown.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

</body>
</html>

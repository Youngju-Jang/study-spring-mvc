<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<script>
    //바닐라
    document.addEventListener('DOMContentLoaded', function() {
        var buttons = document.querySelectorAll('button');

        buttons.forEach(function(button) {
            button.addEventListener('click', function() {
                // alert(this.id);
                location.href = '${pageContext.request.contextPath}/' + this.id;
            });
        });
    });

    //jquery
    <%--$(function () {--%>
    <%--    $('button').click(function () {--%>
    <%--        // alert(this.id);--%>
    <%--        location.href = '${pageContext.request.contextPath}/' + this.id;--%>
    <%--    });--%>
    <%--});--%>


</script>
<body>
<button id="home">HOME</button>
<br>
<button id="app">App Test</button>
<br>
<button id="message">Message</button>
<br>
<button id="lesson">Lesson</button>
<br>
<button id="empValue">EmpValue</button>
<br>
<button id="lessonForm">lessonForm</button>
<br>
<button id="login">login</button>
<br>
<button id="addDemo">addDemo</button>
</body>
</html>



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
<button id="login">login</button>
<br>
<button id="addDemo">addDemo</button>
</body>
</html>



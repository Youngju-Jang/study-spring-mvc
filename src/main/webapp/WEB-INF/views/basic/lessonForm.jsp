<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/lessonCheck" method="post">
    <input type="checkbox" name="lesson" value="java">Java
    <input type="checkbox" name="lesson" value="mysql">mysql
    <input type="checkbox" name="lesson" value="html">html
    <input type="checkbox" name="lesson" value="spring">spring
    <input type="submit" value="Send">
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/empValue" method="post">
        <input type="text" name="job">
        <input type="text" name="sal">
        <input type="submit" value="Send">
    </form>
</body>
</html>

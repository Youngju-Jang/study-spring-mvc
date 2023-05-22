<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<h1>Lesson Check View</h1>
<c:forEach var="i" items="${chValue}">
    <c:out value="${i}"></c:out>
</c:forEach>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
      <meta charset="UTF-8">
      <title>Title</title>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
          $(function () {

          });
      </script>
</head>
<body>
<form action="/addDemo" method="post" content="text/html; charset=UTF-8">
      no: <input type="number" name="no">
      name : <input type="text" name="name">
      message : <input TYPE="text" name="message">
      <input type="submit" value="Insert">
</form>

</body>
</html>

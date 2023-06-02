<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>--%>
<c:forEach items="${productList}" var="cart" varStatus="i">
      <tr>
            <td><input type="checkbox" name="newCartSet" value="${cart.no}"/></td>
            <td>${cart.no}</td>
            <td>${cart.productName}</td>
            <c:choose>
                  <c:when test="${not empty cart.fileName}">
                        <td>
                              <img src="${pageContext.request.contextPath}/resources/downImage/${cart.fileName}"
                                   width="50" height="50"/>
                        </td>
                  </c:when>
                  <c:otherwise>
                        <td></td>
                  </c:otherwise>
            </c:choose>
            <td>${cart.productOrigin}</td>
            <td>${cart.productPrice}</td>
            <td>${cart.productCategory}</td>
            <td>${cart.regdate}</td>
            <td>${cart.seller}</td>
      </tr>
</c:forEach>

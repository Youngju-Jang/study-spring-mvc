<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>--%>
<c:forEach items="${productList}" var="product" varStatus="i">
      <tr>
            <td><input type="checkbox" name="newCartSet" value="${product.no}"/></td>
            <td>${product.no}</td>
            <td>${product.productName}</td>
            <c:choose>
                  <c:when test="${not empty product.fileName}">
                        <td>
                              <img src="${pageContext.request.contextPath}/resources/downImage/${product.fileName}"
                                   width="50" height="50"/>
                        </td>
                  </c:when>
                  <c:otherwise>
                        <td></td>
                  </c:otherwise>
            </c:choose>
            <td>${product.productOrigin}</td>
            <td>${product.productPrice}</td>
            <td>${product.productCategory}</td>
            <td>${product.regdate}</td>
            <td>${product.seller}</td>
      </tr>
</c:forEach>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
    $("ul.pagination a").click(function (event) {
        event.preventDefault(); // 기본 동작 차단
        var href = $(this).attr("href"); // 버튼의 href 값을 가져옴

        $.ajax({
            url: href,
            type: 'GET',
            data: {"forAdmin": true},
            contentType: 'application/x-www-form-urlencoded; charset=euc-kr',
            success: function (data) {
                $("div#paginationView").html('');
                $("div#paginationView").html(data);
            }, error: function () {
                console.log('error');
            }
        });
    });

</script>
<div id="paginationView">
<ul class="pagination">
      <c:if test="${pageBean.currentBlock != 1}">
                  <a href="/product/pageBean?page=1&search=${search}&option=${option}">
                        <img src="${pageContext.request.contextPath}/resources/img/button/btn_first.gif" alt="처음페이지"/>
                  </a>
                  <a href="/product/pageBean?page=${pageBean.startPage-1}&search=${search}&option=${option}">
                        <img src="${pageContext.request.contextPath}/resources/img/button/btn_prev.gif"
                             alt="이전"/></a>
      </c:if>
      <c:forEach begin="${pageBean.startPage}" end="${pageBean.endPage}" var="num">
            <c:choose>
                  <c:when test="${num == pageBean.currentPage}">
                     <a class="active">${num}</a>
                  </c:when>
                  <c:otherwise>
                              <a href="/product/pageBean?page=${num}&search=${search}&option=${option}">${num}</a>
                  </c:otherwise>
            </c:choose>
      </c:forEach>
      <c:if test="${pageBean.endPage<pageBean.totalPage}">
                  <a href="/product/pageBean?page=${pageBean.endPage+1}&search=${search}&option=${option}">
                        <img src="${pageContext.request.contextPath}/resources/img/button/btn_next.gif"
                             alt="다음"/></a>
                  <a href="/product/pageBean?page=${pageBean.totalPage}&search=${search}&option=${option}">
                        <img src="${pageContext.request.contextPath}/resources/img/button/btn_last.gif"
                             alt="마지막페이지"/></a>
      </c:if>
</ul>
<div class="tbWrapLt_content">
      <table class="bbsList">
            <colgroup>
                  <col width="30"/>
                  <col width="100"/>
                  <col width="100"/>
                  <col width="100"/>
                  <col width="100"/>
            </colgroup>
            <thead>
            <tr>
                  <th scope="col">NO.</th>
                  <th scope="col">이미지</th>
                  <th scope="col">상품명</th>
                  <th scope="col">가격</th>
                  <th scope="col">상태</th>

            </tr>
            </thead>

            <tbody>
            <c:forEach items="${productList}" var="product" varStatus="i">
                  <tr>
                        <td>${product.no}</td>
                        <td>
                              <c:if test="${not empty product.fileName}">
                                    <img src="${pageContext.request.contextPath}/resources/downImage/${product.fileName}"
                                         width="50" height="50"/>
                              </c:if>
                        </td>
                        <td>${product.productName}</td>
                        <td>${product.productPrice}</td>
                        <td>
                              <span class="buttonFuc"><a href="#">수정</a></span><span
                                  class="buttonFuc"><a href="#">삭제</a></span>
                        </td>
                  </tr>
            </c:forEach>
            </tbody>
      </table>
</div>

</div>
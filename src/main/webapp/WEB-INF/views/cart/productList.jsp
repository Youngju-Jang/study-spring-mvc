<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

      <!--  관리자페이지 구현 X  -->

      <title>관리자</title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
      <meta http-equiv="X-UA-Compatible" content="IE=10"/>
      <meta http-equiv="imagetoolbar" content="no"/>
      <link href="${pageContext.request.contextPath}/resources/css/default.css" rel="stylesheet" type="text/css"/>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
          $(function () {
              var search = "${search}";
              var option = "${option}";
              var page = "${pageBean.currentPage}";

              $("a#addCart").click(function (e) {
                  e.preventDefault();
                  var checkedCount = $("input[type='checkbox']:checked").length;
                  if (checkedCount == 0) {
                      return false;
                  }
                  $("form[name='addCart']").submit();
              });

              $("a#showMore").click(function (e) {
                  console.log("page : " + page);
                  e.preventDefault();
                  $.ajax({
                      url: '${pageContext.request.contextPath}/product',
                      type: 'GET',
                      data: {
                          "state": "productListView",
                          "page": parseInt(page)+1,
                          "search": search,
                          "option": option
                      },
                      contentType: 'application/x-www-form-urlencoded; charset=euc-kr',
                  }).done(function (data) {
                      $('tbody#dataRows').append(data);
                      $('html, body').animate({ scrollTop: $(document).height() }, 'slow');
                      page++;
                      if(page==${pageBean.totalPage}){
                          $("a#showMore").hide();
                      }
                  }).fail(function () {
                      console.log('error');
                  });
              });
          })
      </script>
</head>
<body>
<div id="wrap">
      <!-- header -->

      <!--// header -->

      <div id="sub_container">
            <div id="contentsWrap" class="sub_con5">
                  <div class="board_form">
                        <div class="con_title">
                              <p>상품 등록/보기/수정</p>
                        </div>

                        <div class="contents">
                              <div class="btnSet clfix mgb15">
						<span class="fr">
							<span class="button"><a href="">목록</a></span>
							<span class="button"><a href="#" id="addCart">장바구니 추가</a></span>
							<span class="button"><a href="/product/add">등록 / 수정</a></span>
						</span>
                              </div>
                              <form action="clientList.do" method="post" name="search">
                                    <table class="bbsWrite mgb35">
                                          <caption></caption>
                                          <colgroup>
                                                <col width="95"/>
                                                <col width="395"/>
                                                <col width="95"/>
                                                <col/>
                                          </colgroup>
                                          <tbody>
                                          <tr>
                                                <th>업체명</th>
                                                <td><select style="width: 200px;">
                                                      <option>선택하세요</option>
                                                </select></td>
                                                <th>
                                                      <select id="query" name="query">
                                                            <option selected="selected">선택하세요</option>
                                                            <option value="productName">상품명</option>
                                                            <option value="productOrigin">원산지</option>
                                                            <option value="productCategory">카테고리</option>
                                                      </select>
                                                </th>
                                                <td><input type="text" name="data"
                                                           style="border:1px solid #ddd; height:20px;" class="inputText"
                                                           size="30"/>
                                                      <span class="button"><a href="#" id="search">검색</a></span>
                                                      <span class="button"><a href="clientList.do" id="search">새로고침</a></span>
                                                </td>
                                          </tr>
                                          </tbody>
                                    </table>
                              </form>
                              <form action="${pageContext.request.contextPath}/cart/add" method="post" name="addCart">
                                    <table class="bbsList">
                                          <colgroup>
                                                <col width="80"/>
                                                <col width="80"/>
                                                <col width="170"/>
                                                <col width="170"/>
                                                <col width="170"/>
                                                <col width="170"/>
                                                <col width="170"/>
                                                <col width="170"/>
                                                <col width="170"/>
                                          </colgroup>
                                          <thead>

                                          <tr>
                                                <th scope="col">장바구니</th>
                                                <th scope="col">NO.</th>
                                                <th scope="col">상품명</th>
                                                <th scope="col">이미지</th>
                                                <th scope="col">원산지</th>
                                                <th scope="col">가격</th>
                                                <th scope="col">종류</th>
                                                <th scope="col">날짜</th>
                                                <th scope="col">판매자</th>

                                          </tr>
                                          </thead>

                                          <tbody id="dataRows">
                                          <c:forEach items="${productList}" var="product" varStatus="i">
                                                <tr>
                                                      <td><input type="checkbox" name="newCartSet"
                                                                 value="${product.no}"/></td>
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
                                          </tbody>
                                    </table>
                              </form>
                              <a id="showMore" href="#">더보기</a>
                        </div>
                  </div>
            </div>
      </div>
      <!--Footer-->

      <!--END Footer-->
</div>
</body>
</html>
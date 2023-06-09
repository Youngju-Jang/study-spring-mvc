<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

      <title>관리자</title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
      <meta http-equiv="X-UA-Compatible" content="IE=10"/>
      <meta http-equiv="imagetoolbar" content="no"/>
      <!-- <link href="../css/contents.css" rel="stylesheet" type="text/css" /> -->
      <link href="${pageContext.request.contextPath}/resources/css/default.css" rel="stylesheet" type="text/css"/>


</head>
<body>
<div id="wrap">
      <!-- header -->

      <!--// header -->

      <div id="sub_container">
            <div id="contentsWrap" class="sub_con5">
                  <div class="board_form">
                        <div class="con_title">
                              <p>장바구니 리스트</p>
                        </div>
                        <div class="contents">

                              <div class="btnSet clfix mgb15">
						<span class="fr"> <span class="button"><a href="/product">목록</a></span>
						</span>
                              </div>

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
                                          <td><select style="border:1px solid #ddd; height:20px; width:200px;">
                                                <option>선택하세요</option>
                                          </select></td>
                                          <th>상품명</th>
                                          <td><input type="text" name="" class="" size="30"
                                                     style="border:1px solid #ddd; height:20px;"/>
                                                <span class="button"><a href="#">검색</a></span></td>
                                    </tr>
                                    </tbody>
                              </table>
                              <table class="bbsList">
                                    <colgroup>
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
                                          <th scope="col">NO.</th>
                                          <th scope="col">상품명</th>
                                          <th scope="col">이미지</th>
                                          <th scope="col">원산지</th>
                                          <th scope="col">가격</th>
                                          <th scope="col">종류</th>
                                          <th scope="col">수량</th>
                                          <th scope="col">상태</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${cartSet}" var="cart" varStatus="i">
                                          <tr>
                                                <td>${cart.no}</td>
                                                <td>${cart.productName}</td>
                                                <c:choose>
                                                      <c:when test="${not empty cart.fileName}">
                                                            <td>
                                                                  <a>
                                                                        <img src="${pageContext.request.contextPath}/resources/downImage/${cart.fileName}"
                                                                             width="50" height="50"/>
                                                                  </a>
                                                            </td>
                                                      </c:when>
                                                      <c:otherwise>
                                                            <td></td>
                                                      </c:otherwise>
                                                </c:choose>
                                                <td>${cart.productOrigin}</td>
                                                <td>${cart.productPrice}</td>
                                                <td>${cart.productCategory}</td>
                                                <td><input type="number" name="count" value="${cart.count}"/></td>
                                                <td>
										<span class="buttonFuc"><a href="#">구매</a>
										</span>
                                                      <span class="buttonFuc">
										
											<a href="">삭제</a></span>
                                                </td>
                                          </tr>
                                    </c:forEach>
                                    </tbody>
                              </table>
                              <table class="bbsList" align="right">
                                    <tr align="right">
                                          <th align="right">총합계 &nbsp; <input type="text" name="total" id="total"
                                                                              class="inputText" size="30" align="right"
                                                                              value="0"/></th>
                                    </tr>
                              </table>
                        </div>
                  </div>
            </div>
      </div>
      <!--Footer-->

      <!--END Footer-->
</div>


</body>
</html>
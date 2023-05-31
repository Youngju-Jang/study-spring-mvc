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
      <link href="${pageContext.request.contextPath}/resources/css/contents.css" rel="stylesheet" type="text/css"/>
      <link href="${pageContext.request.contextPath}/resources/css/default.css" rel="stylesheet" type="text/css"/>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
          $(function () {

            // 상품등록 버튼 클릭시 수정아닌 버튼으로 작동하도록
              $("li[id='addProduct']").click(function(){
                  $("li[id='addProduct']").addClass('over');
                  $("li[id='editProduct']").removeClass('over');
                  $("span[id='addProduct']").show();
                  $("span[id='editProduct']").hide();

                  $("input[name='productName']").val('');
                  $("input[name='productOrigin']").val('');
                  $("input[name='productPrice']").val('');
                  $("select[name='productCategory']").val("").prop("selected", true);

                  $("form[name='frm']").prop("action", "/product/add");
              });
              // 좌측 리스트내용 채우기용 ajax
              var page = ${page} == null ? 1 : ${page};
              $.ajax({
                  url: '${pageContext.request.contextPath}/product',
                  type: 'GET',
                  data: { "forAdmin" : true, "page":page},
                  contentType: 'application/x-www-form-urlencoded; charset=euc-kr',
                  success: function (data) {
                      $("div.tbWrapLt").html('');
                      $("div.tbWrapLt").html(data);
                  }, error: function () {
                      console.log('error');
                  }
              });

              $("a#save, a#edit").click(function () {
                  if ($("select[name='productCategory']").val() == '') {
                      alert("카테고리를 선택해주세요");
                      return false;
                  }
                  if ($("input[name='productName']").val().length == 0 || $("input[name='productPrice']").val().length == 0) {
                      alert('상품명이나 상품가격은 필수사항입니다.');
                      $("input[name='productName']").focus();
                      return false;
                  } else {
                      $("form[name='frm']").submit();
                  }
              });
          });

      </script>
</head>
<body>
<div id="wrap">
      <div id="sub_container">
            <div id="contentsWrap" class="sub_con5">
                  <div class="board_form">
                        <div class="con_title">
                              <p>상품등록/보기/수정</p>
                        </div>


                        <div class="contents">
                              <div class="btnSet clfix mgb15">
						<span class="fr"> <span class="button"><a href="#">목록</a></span>
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
                                          <td><select style="width: 200px;">
                                                <option>선택하세요</option>
                                          </select></td>
                                          <th>상품명</th>
                                          <td><input type="text" name="" style="border:1px solid #ddd; height:20px;"
                                                     class="inputText" size="30"/>
                                                <span class="button"><a href="#">검색</a></span></td>
                                    </tr>
                                    </tbody>
                              </table>

                              <div class="clfix">
                                    <div class="tbWrapLt">
                                          <ul class="pagination"></ul>
                                          <div class="tbWrapLt_content"></div>
                                    </div>

                                    <div class="tbWrapRt">
                                          <ul class="tabA clfix mgb15">
                                                <li class="over" id="addProduct"><a>01. 상품등록</a></li>
                                                <li id="editProduct"><a>02. 상품수정</a></li>
                                          </ul>
                                          <form action="${pageContext.request.contextPath}/product/add" name="frm"
                                                enctype="multipart/form-data"
                                                method="post" id="addProduct">
                                                <div id="info1" class="tbWrapCnt" style="display: block;">
                                                      <table class="bbsWrite mgb10">
                                                            <caption></caption>
                                                            <colgroup>
                                                                  <col width="95"/>
                                                                  <col/>
                                                            </colgroup>
                                                            <tbody>

                                                            <tr>
                                                                  <th>상품명</th>
                                                                  <td><input type="text"
                                                                             style="border:1px solid #ddd; height:20px;"
                                                                             name="productName" class="inputText"
                                                                             size="50"/></td>
                                                            </tr>
                                                            <tr>
                                                                  <th>원산지</th>
                                                                  <td><input type="text"
                                                                             style="border:1px solid #ddd; height:20px;"
                                                                             name="productOrigin" class="inputText"
                                                                             size="50"/></td>
                                                            </tr>
                                                            <tr>
                                                                  <th>상품가격</th>
                                                                  <td><input type="text"
                                                                             style="border:1px solid #ddd; height:20px;"
                                                                             name="productPrice" class="inputText"
                                                                             size="50"/>
                                                                        <input type="hidden" name="id" value="${id}"/>
                                                                  </td>
                                                            </tr>
                                                            <tr>
                                                                  <th>카테고리</th>
                                                                  <td>
                                                                        <select style="width: 200px;"
                                                                                name="productCategory">
                                                                              <option selected="selected" Value="">
                                                                                    선택하세요
                                                                              </option>
                                                                              <option value="cloth">의류/잡화</option>
                                                                              <option value="electronic">전자제품</option>
                                                                              <option value="furniture">가구</option>
                                                                              <option value="cosmetic">화장품/향수</option>
                                                                              <option value="foods">식품/주류</option>
                                                                              <option value="car">차량용품</option>
                                                                        </select>
                                                                  </td>
                                                            </tr>
                                                            <tr>
                                                                  <th>상품이미지1</th>
                                                                  <td class="alignM"><input type="file" name="file"
                                                                                            id="file"
                                                                                            class="inputText"/>
                                                                        <%--															  size="10" />--%>
                                                                  </td>
                                                            </tr>
                                                            </tbody>
                                                      </table>
                                                </div>
                                          </form>
                                    </div>

                                    <p class="agr">
                                          <span class="button" id="addProduct"><a id="save">저장</a></span>
                                          <span class="button" id="editProduct" style="display: none;"><a id="edit">수정</a></span>
                                    </p>
                              </div>
                        </div>
                  </div>
            </div>
      </div>

      <!--Footer-->

      <!--END Footer-->
</div>

</body>
</html>
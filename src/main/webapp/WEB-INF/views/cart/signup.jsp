<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Start Simple Web</title>
      <link href="${pageContext.request.contextPath}/resources/css/contents.css?ver=1" rel="stylesheet"
            type="text/css"/>
      <link
                href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
                rel='stylesheet' type='text/css'>
      <link
                href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
                rel='stylesheet' type='text/css'>

      <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
      <script>
          $(function () {
              $("img#btnSubmit").click(function () {
                  if ($("input[name='name']").val().length == 0 || $("input[type='password']").val().length == 0) {
                      alert('ID OR PASS CHECK!');
                      $("input[name='name']").val('');
                      $("input[type='password']").val('');
                      $("input[name='name']").focus();
                      return false;
                  }
                  if ($("input[name='password']").val() != $("input[name='passwordCheck']").val()) {
                      alert('비밀번호가 다릅니다!');
                      $("input[type='password']").val('');
                      $("input[type='passwordCheck']").val('');
                      $("input[type='password']").focus();
                      return false;
                  } else {
                      $.ajax({
                          url: '${pageContext.request.contextPath}/signup',
                          type: 'POST',
                          data: {"name": $("input#name").val(), "password": $("input#password").val()},
                          success: function (data) {
                              console.log(data);
                              if (data.trim() == 'T') {
                                  document.location.href = '/login';
                              } else {
                                  alert("이미 존재하는 아이디입니다.");
                                  $("input[name='name']").val('');
                                  $("input[name='password']").val('');
                                  $("input[name='name']").focus();
                              }
                          }, error: function () {
                              console.log('error');
                          }
                      });
                  }
              });
          });
      </script>
</head>
<body>
<form name="login" method="post">
      <div id="loginWrapper">
            <div class="loginForm">
                  <fieldset>
                        <legend>관리자 시스템 회원가입</legend>
                        <dl>
                              <dt><img src="${pageContext.request.contextPath}/resources/img/common/th_id.gif" alt="아이디" /></dt>
                              <dd><input type="text" name="name" class="text" id="name" /></dd>

                              <dt><img src="${pageContext.request.contextPath}/resources/img/common/th_pw.gif" alt="비밀번호" /></dt>
                              <dd><input type="password" name="password" class="text" id="password" /></dd>

                              <dt><img src="${pageContext.request.contextPath}/resources/img/common/th_pw.gif" alt="비밀번호" /></dt>
                              <dd><input type="password" name="passwordCheck" class="text" id="passwordCheck" placeholder="비밀번호 확인"/></dd>
                        </dl>
                        <div class="btn">
                              <img id="btnSubmit" src="${pageContext.request.contextPath}/resources/img/button/btn_login.gif"
                                   alt="SIGNUP" title="SIGNUP"  />
                        </div>
                  </fieldset>
            </div>
      </div>
</form>

</body>

</html>
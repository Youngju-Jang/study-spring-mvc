<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <title>������</title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
      <meta http-equiv="X-UA-Compatible" content="IE=10"/>
      <meta http-equiv="imagetoolbar" content="no"/>
      <meta name="copyright" content="Copyright 2020 @ high1 all rights reserved"/>
      <link href="../css/contents.css" rel="stylesheet" type="text/css"/>
      <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
      <script>
          $(function () {
              $("img#btnSubmit").click(function () {
                  if ($("input[name='id']").val().length == 0 || $("input[name='pw']").val().length == 0) {
                      alert('ID OR PASS CHECK!');
                      $("input[name='id']").val('');
                      $("input[name='pw']").val('');
                      $("input[name='id']").focus();
                      return false;
                  }
              $("form[name='login']").submit();
              });
          });
      </script>

</head>
<body>
<form name="login" method="post" action="/login">
      <div id="loginWrapper">
            <div class="loginForm">
                  <fieldset>
                        <legend>������ �ý��� �α���</legend>
                        <dl>
                              <dt><img src="../img/common/th_id.gif" alt="���̵�"/></dt>
                              <dd><input type="text" name="id" class="text" id="id"/></dd>

                              <dt><img src="../img/common/th_pw.gif" alt="��й�ȣ"/></dt>
                              <dd><input type="password" name="pw" class="text" id="pw"/></dd>
                        </dl>
                        <div class="btn">
                              <img id="btnSubmit" src="../img/button/btn_login.gif" alt="LOGIN" title="LOGIN"/>
                        </div>

                        <div class="saveId"><input type="checkbox" id="checker" name="checker"/>
                              <img src="../img/common/save_id.gif" alt="���̵� ����"/>
                        </div>
                  </fieldset>
            </div>
      </div>
</form>
</body>
</html>
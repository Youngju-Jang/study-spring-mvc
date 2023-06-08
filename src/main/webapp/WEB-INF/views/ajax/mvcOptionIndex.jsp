<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
  function ajaxProcess(url,type,contentType,dataType){
	  
  }
  $(function(){
	  $("input[type='button']").click(function(){
		    switch (this.id) {
			case 'ajax1':
				ajaxProcess();
				break;
			default:
				break;
			}
	  }); 
  });
</script>
</head>
<body>
<%-- <a href="${pageContext.request.contextPath}/pathParam">EMPLIST</a>
<a href="${pageContext.request.contextPath}/pathParam/JONES">EMPLIST1</a>
<a href="${pageContext.request.contextPath}/pathParam/SMITH/SALESMAN">EMPLIST2</a>
<a href="${pageContext.request.contextPath}/pathParam/ALLEN/MANAGER">EMPLIST3</a> --%>
  
<input type="button" value="AjaxValue1" id="ajax1">
<input type="button" value="AjaxValue2" id="ajax2">
<input type="button" value="AjaxValue3" id="ajax3">

</body>
</html>
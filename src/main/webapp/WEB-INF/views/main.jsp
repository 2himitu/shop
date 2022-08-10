<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">

<!-- Side Navigation -->

<body>
<header class="w3-container w3-theme w3-padding" id="myHeader">
  <i onclick="w3_open()" class="fa fa-bars w3-xlarge w3-button w3-theme"></i> 
  <div class="w3-center">
  <h4>����� ���� ���� �����Կ�</h4>
  <h1 class="w3-xxxlarge w3-animate-bottom">�ӽ� ���� ȭ��</h1>
    <div class="w3-padding-32">
<jsp:include page="common/top.jsp" flush="false"></jsp:include><br>
    </div>
  </div>
</header>
<c:if test="${!empty mesg }">
	<script type="text/javascript">
	 alert("${mesg}")
	</script>
</c:if>

<jsp:include page="common/menu.jsp" flush="false"></jsp:include>
<hr>
<jsp:include page="goods/goodsList.jsp" flush="false"></jsp:include>
</body>
</html>
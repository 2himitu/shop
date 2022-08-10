<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">

<body>
<header class="w3-container w3-theme w3-padding" id="myHeader">
  <i onclick="w3_open()" class="fa fa-bars w3-xlarge w3-button w3-theme"></i> 
  <div class="w3-center">
  <h4>최호종 바보 </h4>
  <h1 class="w3-xxxlarge w3-animate-bottom">누가 장바구니에 넣을래?</h1>
    <div class="w3-padding-32">
<jsp:include page="common/top.jsp" flush="false"></jsp:include><br>
    </div>
  </div>
</header>
<jsp:include page="common/menu.jsp" flush="true" />
<hr>
<jsp:include page="goods/cartList.jsp" flush="true" />
</body>
</html>
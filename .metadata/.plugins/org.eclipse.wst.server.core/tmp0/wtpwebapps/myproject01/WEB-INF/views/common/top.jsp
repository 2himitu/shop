<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:if test="${empty login}">
    <a href="main">hom</a>
    <a href="loginUI">로그인</a>
    <a href="memberUI">회원가입</a>
    
    </c:if>
    <c:if test="${! empty login}">
    <a href="main">hom</a>
	<br>
    <a href="logOut">로그아웃</a>
    <a href="mypage">mypage</a>
    <a href="cartList">장바구니</a>
    </c:if>
    
<dr>


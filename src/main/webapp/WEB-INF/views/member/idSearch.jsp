<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<c:if test="${!empty mesg }">
	<script type="text/javascript">
	 alert("${mesg}")
	</script>
</c:if>
<form action="MemberIdSearch" method="get">
  이름<input type="text" name="username"><br>
 휴대폰<select name="phone1">
       <option value="011">011</option>
       <option value="010">010</option>
     </select>-
      <input type="text" name="phone2">-
      <input type="text" name="phone3"><br>
이메일<input type="text"  name="email1">@
     <input type="text"  name="email2" id="email2" placeholder="직접 입력">
   <input type="submit" value="메일 보내기">  
</form>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login</title>
</head>
<body>
	login
	<!-- 로그인 실페 -->
	<c:if test="${sessionMember == null }">
		<form action="${pageContext.request.contextPath}/login" method="post">
			<div>ID :
			<input type="text" name="memberId" value="goodee@gdu.co.kr"> </div>
			<div>PW : 
			<input type="password" name="memberPw" value="1234"></div>
			<div><button type="submit">로그인</button></div>
		</form>
	</c:if>
	
	<!-- 로그인 성공 -->
	<c:if test="${sessionMember != null }">
		${sessionMember.memberId }님 반갑습니다.
		<div><a href="${pageContext.request.contextPath}/logout"> 다이어리</a></div>
		<div> <a href="${pageContext.request.contextPath}/auth">로그아웃</a></div>
	</c:if>
</body>
</html>
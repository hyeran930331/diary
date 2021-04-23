<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>

</head>
<body>
	<h1>login</h1>
	<!-- 로그인 실페 -->
	<c:if test="${sessionMember == null }">
		<form action="${pageContext.request.contextPath}/login" method="post">
			<div>ID :
			<input type="text" name="memberId" value="mentorrani0331@gmail.com"> </div>
			<div>PW : 
			<input type="password" name="memberPw" value="1234"></div>
			<div><button type="submit">로그인</button></div>
		</form>
		<div> <a href="${pageContext.request.contextPath}/addMember">회원가입</a></div>
	</c:if>
	
	<!-- 로그인 성공 -->
	<c:if test="${sessionMember != null }">
		(${sessionMember.memberNo}번째 고객) ${sessionMember.memberId }님 반갑습니다.
		<div><a href="${pageContext.request.contextPath}/auth"> (구현전)다이어리</a></div>
		<div> <a href="${pageContext.request.contextPath}/auth/modifyMember">정보수정</a></div>
		<div> <a href="${pageContext.request.contextPath}/auth/removeMember">탈퇴</a></div>
		<div> <a href="${pageContext.request.contextPath}/auth/logout">로그아웃</a></div>
	</c:if>
</body>
</html>
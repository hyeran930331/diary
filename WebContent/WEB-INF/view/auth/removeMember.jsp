<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>removeMember</title>
</head>
<body>
<h1>remove Member</h1>
	<form action="${pageContext.request.contextPath}/auth/removeMember" method="post">
		<div>ID :
		<input type="text" name="memberId" readonly="readonly" value="${sessionMember.memberId}"> </div>
		<div>No :
		<input type="text" name="memberNo" readonly="readonly" value="${sessionMember.memberNo}"> </div>
		<div>PW : 
		<input type="password" name="memberPw"></div>
		<button type="submit" > 탈퇴</button>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addMember</title>
</head>
<body>
	<h1>addMember</h1>
	
	<c:if test="${sessionMember == null }">
		<form action="${pageContext.request.contextPath}/addMember" method="post">
			<div>ID :
			<input type="text" name="memberId"> </div>
			<div>PW : 
			<input type="password" name="memberPw"></div>
			<div><button type="submit">회원가입</button></div>
		</form>
	</c:if>
</body>
</html>
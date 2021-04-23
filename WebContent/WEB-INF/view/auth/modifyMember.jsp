<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify member</title>
</head>
<body>
	<h1>modify</h1>
	<c:if test="${sessionMember != null }">
		<form action="${pageContext.request.contextPath}/modifyMember" method="post">
			<div>ID :
			<input type="text" name="memberId" value="${sessionMember.meberId}"> </div>
			<div>PW : 
			<input type="password" name="memberPw"></div>
			<div><button type="submit">수정</button></div>
		</form>
		<div> <a href="${pageContext.request.contextPath}/login">홈으로</a></div>
	</c:if>
	
</body>
</html>
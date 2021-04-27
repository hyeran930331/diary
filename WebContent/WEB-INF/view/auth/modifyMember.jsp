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
	<h1>modify: no ID date 는 수정불가</h1>
	<c:if test="${sessionMember != null }">
		<form action="${pageContext.request.contextPath}/auth/modifyMember" method="post">
			<div>ID :
			<input type="text" readonly="readonly" value="${sessionMember.memberId}"> </div>
			<div>No :
			<input type="text" name="memberNo" readonly="readonly" value="${sessionMember.memberNo}"> </div>
			<div>현재PW : 
			<input type="password" name="oldMemberPw"></div>
			<div>바꿀PW : 
			<input type="password" name="newMemberPw"></div>
			<div><button type="submit">수정</button></div>
		</form>
	</c:if>
	
	<div> <a href="${pageContext.request.contextPath}/login">홈으로</a></div>
	
</body>
</html>
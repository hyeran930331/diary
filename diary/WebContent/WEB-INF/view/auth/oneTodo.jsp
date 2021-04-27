<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세보기</h1>
	
		<div>todoDate : ${oneTodo.todoDate} <!--  --> </div>
		<div style="background-color:${oneTodo.todoFontColor}"> <a href="#">배경색</a> </div>
		<div>todoTitle : ${oneTodo.todoTitle} </div>
		<div>todoContent : ${oneTodo.todoContent} </div>
		<div>
		<a href="${pageContext.request.contextPath}/auth/modifyTodo?todoNo=${oneTodo.todoNo}">수정</a>
		<a href="${pageContext.request.contextPath}/auth/removeTodo?todoNo=${oneTodo.todoNo}">삭제</a>
		<a href="${pageContext.request.contextPath}/auth/diary">돌아가기</a>
		</div>
</body>
</html>
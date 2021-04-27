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
	<h1>일정보기</h1>

	<form action="${pageContext.request.contextPath}/auth/modifyTodo?todoNo=${oneTodo.todoNo}" method="post">
		<div>todoDate : <input type="text" name="todoDate" value="${oneTodo.todoDate}"></div>
		<div style="background-color:${oneTodo.todoFontColor}"> todoFontColor :<input type="color" name="todoFontColor" value="${oneTodo.todoFontColor}"> </div>
		<div>todoTitle :<input type="text" name="todoTitle" value="${oneTodo.todoTitle}"> </div>
		<div>todoContent :<textarea name="todoContent"cols="80" rows="5">${oneTodo.todoContent}</textarea> </div>
		<button type="submit">수정</button>
	</form>
		<a href="${pageContext.request.contextPath}/auth/removeTodo?todoNo=${oneTodo.todoNo}">삭제</a>
		<a href="${pageContext.request.contextPath}/auth/diary">돌아가기(오늘)</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add todo</title>
</head>
<body>
	<h1>일정 입력</h1>
	<form action="${pageContext.request.contextPath}/auth/addTodo" method="post">
		<div>todoDate : <input type="text" name="todoDate" value="${todoDate.toString()}" readonly="readonly"></div>
		<div>todoFontColor :<input type="color" name="todoFontColor"> </div>
		<div>todoTitle :<input type="text" name="todoTitle"> </div>
		<div>todoContent :<textarea name="todoContent"cols="80" rows="5"></textarea> </div>
		<button type="submit">addTodo</button>
		<div></div>
	</form>
</body>
</html>
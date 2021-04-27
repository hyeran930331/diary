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

		<div>todoDate : ${oneTodo.todoDate}"> </div>
		<div style="background-color:${oneTodo.todoFontColor}"> </div>
		<div>todoTitle : ${oneTodo.todoTitle} </div>
		<div>todoContent : ${oneTodo.todoContent} </div>

</body>
</html>
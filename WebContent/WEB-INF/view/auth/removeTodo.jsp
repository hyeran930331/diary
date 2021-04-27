<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>삭제</h1>
	
	<form action="${pageContext.request.contextPath}/auth/removeTodo?todoNo=${oneTodo.todoNo}" method="post">
		<div>todoDate : <input readonly="readonly" type="text" name="todoDate" value="${oneTodo.todoDate}"></div>
		<div style="background-color:${oneTodo.todoFontColor}"> todoFontColor :<input readonly="readonly" type="color" name="todoFontColor" value="${oneTodo.todoFontColor}"> </div>
		<div>todoTitle :<input readonly="readonly" type="text" name="todoTitle" value="${oneTodo.todoTitle}"> </div>
		<div>todoContent :<textarea readonly="readonly" name="todoContent"cols="80" rows="5">${oneTodo.todoContent}</textarea> </div>
		membetPw : <input type="password" name="memberPw"> <button type="submit">삭제</button>
	</form>
		<div>
		<a href="${pageContext.request.contextPath}/auth/diary">돌아가기(오늘)</a>
		</div>
</body>
</html>
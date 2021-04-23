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
	<div> ${diaryMap.targetYear}년  ${diaryMap.targetMonth} 월 ${diaryMap.endDay}일이 끝!</div>
	<div> 첫번째 날짜의 시작일은${diaryMap.startBlank} -> 이걸 토대로 알수 있는 요일 -> 일0 월1 화2 수3 목4 금5 토6</div>
	<div> -> 앞에 있는 공백은 ${diaryMap.startBlank} -> (일요인0 월요일1 화요일2 수요일3 목요일4 금요일5 토요일 6)개</div>
	<div> 전체 출력될 cell 수는 : ${diaryMap.totalCell }</div>
	
	<h1>
		<a href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.targetYear}&targetMonth=${diaryMap.targetMonth-1}">이전달</a>
		<a href="${pageContext.request.contextPath}/auth/diary?targetYear=${diaryMap.targetYear}&targetMonth=${diaryMap.targetMonth+1}">다음달</a>
	</h1>
	<table border="1" width="90%">	
		<tr>
			
			
			<c:forEach var="i" begin="1" end="${diaryMap.totalCell}" step="1"><!-- for (int i =1; i<totalCell; i++){ -->
						
				<c:if test="${i }=< ${startBlank}"> <!--i가 startblank갯수만큼은 빈칸출력 -->
					<td>
					&nbsp;		
				</c:if>
				
				<c:set var="num" value="${i-diaryMap.startBlank}"></c:set> <!-- num은 앞에 출력한 startblank를뺀 전체 출력수 -->
				<c:if test="${num>0 && num <= diaryMap.endDay}"> <!--num이 endDay갯수만큼은 빈칸출력 -->
					<td>
					<a href="${pageContext.request.contextPath}/auth/addTodo"> ${num} </a>
				</c:if>
				
				<c:if test="${num >diaryMap.endDay}"> <!--num이  endDay갯수보다 클때는 -->
					<td>
					&nbsp;
				</c:if>
				
					</td>
				
				<c:if test="${(i%7) == 0}"> <!-- i가 7로 나누어떨어진다면, 출을 띄운다. -->
					<tr></tr>
				</c:if>
				
			</c:forEach>
		</tr>
	</table>
</body>
</html>
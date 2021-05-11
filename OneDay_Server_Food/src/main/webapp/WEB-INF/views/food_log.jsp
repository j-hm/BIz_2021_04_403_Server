<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>입력결과</h2>
	<c:if test="${empty FOOD}">입력오류</c:if>
	<table border="1">
		<th>날짜</th>
		<th>식품코드</th>
		<th>섭취량</th>
		<tr>
			<td>${FOOD.mf_date}</td>
			<td>${FOOD.mf_fcode}</td>
			<td>${FOOD.mf_count}</td>
	</table>
	<p>
	<form action="/HelpDiet/">
	<button>홈으로</button>
	</form>
</body>
</html>
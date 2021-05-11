<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2>조회결과</h2>
		<c:if test="${empty MYLIST}">정보 없음</c:if>
		<table border="1">
			<th>날짜</th>
			<th>식품코드</th>
			<th>식품명</th>
			<th>섭취량</th>
			<th>단백질</th>
			<th>지방</th>
			<th>탄수화물</th>
			<th>총당류</th>
			<th>총섭취칼로리</th>
		<c:forEach items="${MYLIST}" var="DATA">
		<tr>
			<td>${DATA.my_date}</td>
			<td>${DATA.my_fcode}</td>
			<td>${DATA.my_name}</td>
			<td>${DATA.my_count}</td>
			<td>${DATA.my_protein}</td>
			<td>${DATA.my_fat}</td>
			<td>${DATA.my_carb}</td>
			<td>${DATA.my_sugar}</td>
			<td>${DATA.my_totalKcal}</td>
		</tr>
		</c:forEach>
		</table>
		<p>
		<form action="/HelpDiet/">
		<button>홈으로</button>
		</form>
</body>
</html>
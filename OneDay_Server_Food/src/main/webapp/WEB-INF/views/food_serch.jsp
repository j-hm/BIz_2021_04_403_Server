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
	<h2>식품명 검색</h2>
	<form method="POST">
		<p><label>식품 이름 : </label><input name = "f_name"/> <button>검색</button> </p>
		<h2>조회결과</h2>
		<c:if test="${empty FOODLIST}">정보 없음</c:if>
		<table border="1">
			<th>식품코드</th>
			<th>식품명</th>
			<th>제조회사</th>
			<th>분류</th>
		<c:forEach items="${FOODLIST}" var="FOOD">
		<tr>
			<td><a href="info?f_code=${FOOD.f_code}">${FOOD.f_code}</a></td>
			<td>${FOOD.f_name}</td>
			<td>${FOOD.f_ccode}</td>
			<td>${FOOD.f_icode}</td>
		</tr>
		</c:forEach>
		</table>
	</form>
</body>
</html>
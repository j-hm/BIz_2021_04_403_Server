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
	<h1>조회결과</h1>
	<c:if test="${empty MYLIST}">정보 없음</c:if>
	<c:forEach items="${MYLIST}" var="DATA">
	<p>날짜 : ${DATA.my_date}</p>
	<p>식품코드 : ${DATA.my_fcode}</p>
	<p>식품명 : ${DATA.my_name}</p>
	<p>섭취량 : ${DATA.my_count}</p>
	<p>단백질 : ${DATA.my_protein}</p>
	<p>지방 : ${DATA.my_fat}</p>
	<p>탄수화물 : ${DATA.my_carb}</p>
	<p>총당류 : ${DATA.my_sugar}</p>
	<p>총칼로리 : ${DATA.my_totalKcal}</p>
	</c:forEach>
</body>
</html>
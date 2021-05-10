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
	<h1>다이어트를 도와줘</h1>
	<a href="/HelpDiet/food/">섭취정보등록</a>
	<h3>날짜로 데이터 조회하기</h3>
	<form action="/HelpDiet/list/">
		<p><label>날짜 : </label><input name = "my_date"/> <button>검색</button> </p>
	</form>
</body>
</html>
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
	<h1>다이어트를 도와줘</h1>
	<a href="/HelpDiet/food/serch">
		<button>섭취정보등록</button>
	</a>
	<p>
	<h2>날짜로 데이터 조회하기</h2>
	<h4>날짜는 YYYY-MM-DD 형식으로 입력해주세요</h4>
	<form action="/HelpDiet/SerchByDate/">
		<p>
			<label>날짜 : </label><input name="my_date" />
			<button>검색</button>
		</p>
	</form>
		<table border="1">
			<th>일련번호</th>
			<th>날짜</th>
			<th>식품코드</th>
			<th>식품명</th>
			<th>섭취량</th>
			<th>단백질</th>
			<th>지방</th>
			<th>탄수화물</th>
			<th>총당류</th>
			<th>총칼로리</th>
			<c:forEach items="${MYLIST}" var="DATA">
				<tr>
					<td>${DATA.my_seq}</td>
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
</body>
</html>
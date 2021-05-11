<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>섭취정보등록</h2>
	<h4>날짜는 YYYY-MM-DD 형식으로 입력해주세요</h4>
	<form method="POST">
		<p><label>날짜 : </label><input name = "mf_date"/></p>
		<p><label>식품코드 : </label><input name = "mf_fcode" value="${f_code}"/></p>
		<p><label>섭취량 : </label><input name = "mf_count"/></p>
		<p><button>기록하기</button>
	</form>
	
</body>
</html>
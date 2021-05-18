<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<%--
외부에서 css파일을 가져오기 : 
webapp폴더는 프로젝트의 외부에서 접근할 때
root Folder로 인식된다
슬래시(/)로 시작되는 경로는 webapp폴더로 인식된다

그런데 지금 프로젝트에서 슬래시로 접근하는 모든 요청은 
홈컨트롤러가 catcher하도록 만들어져있기 때문에 어떠한 파일로 연결을 할 수 없다.

--%>
<link rel="stylesheet" href="/diet/css/home.css?ver=1" />
</head>
<body>
	<h1>&#127775;다이어트를 도와줘&#127775;</h1>
	<%--/diet/food/search --%>
	<a href="${pageContext.request.contextPath}/food/search">섭취정보등록&#128221;</a>
	<div>
		<form>
			<label>날짜</label> <input name="mf_date">
		</form>
	</div>
	<%-- 다른 JSP파일 연결하기 --%>
	<%@ include file="/WEB-INF/views/list.jsp"%>
</body>
</html>
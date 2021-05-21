<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value = "${pagaContext.request.contextPath}" var = "rootPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form.v1{
		width: 80%;
		margin: 10px auto;
	}
	/* 공통속성을 한 번에 지정하기 */
	form.v1 label,form.v1 input{
		display: inline-block;
		padding: 5px;
		margin: 5px;
	}
	form.v1 label{
		width: 150px;
		text-align: right;
	}
	form.v1 input{
		width: 300px;
		border: 1px soild green;
		border-radius: 5px;
	}
	form.v1 fieldset{
		border-radius: 10px;
		border: 1px soild blue;
		padding: 5px;
	}
	form.v1 button{
		outline:0;
		border:0;
		width: 100px;
		color: white;
	}
	form.v1 button:nth-child(1){
		background-color: green;
	}
	form.v1 button:nth-child(2){
		background-color: orange;
	}
	form.v1 button:hover{
		box-shadow: 2px 2px 2px rgba(0,0,0,0.3)
	}
	form.v1 div:nth-child(8) {
		text-align: right;
		width: 460px;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp"%>
	<form class="v1" method="POST">
		<fieldset>
		<legend>방명록 쓰기</legend>
		<div>
		<label>작성일자</label>
		<input>
		</div>
		
		<div>
		<label>작성시간</label>
		<input>
		</div>
		
		<div>
		<label>작성자</label>
		<input>
		</div>
		
		<div>
		<label>작성자 Email</label>
		<input>
		</div>
		
		<div>
		<label>비밀번호</label>
		<input>
		</div>
		
		<div>
		<label></label>
		<input>
		</div>
		
		<div>
			<button>저장</button>
			<button>처음으로</button>
		</div>
		</fieldset>
	</form>
</body>
</html>
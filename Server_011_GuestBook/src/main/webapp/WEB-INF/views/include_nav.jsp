<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
	/*
	CSS를 사용하여 화면을 디자인 할 때 항상 제일 먼저 있어야할 설정
	기본 HTML의 margin, padding을 clear(ReSet)하여
	이후에 작성된 CSS의 margin, padding을 원할하게 적용시키기 위함
	
	box-sizing: border-box;
	Block type tag를 사용하여 화면을 그릴 때
	margin, padding, border 값을 지정할 때 좌우로 벗어나서 그려지는 현상을 없애기 위함
	*/
	*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	}
	h1.main {
	background-color: #fefaa0;
	padding:2rem;
	text-align: center;
	}
	nav#main {
		background-color: #fed065;
	}
	/*
	ul tag는 본문에서 보편적으로 list 등을 표현할 때
	많이 사용하는 tag이다
	ul tag만을 selector하여 style을 지정하면 혹시 nav가 아닌 영역에서 작성된
	ul tag에도 같은 속성이 설정되는 현상이 발생한다
	
	이런한 불편함을 제거하기 위하여
	css selctor지정을 좀 더 세분화 하기로 한다
	nav#main ul {  }
	id가 main인 nav box내부에 있는 ul tag에만
	제한적으로 적용하라는 의미로 사용한다
	본문의 다른 곳에 있는 ul에는 속성을 적용하지 말라
	*/
	nav#main ul {
		margin:0px;
		background-color: #fed065;
	}
	
	nav#main li {
		display :inline-block;
		list-style : none;
		margin: 0px;
		padding:10px;
		color:white;
	}
	
	nav#main li:hover {
		background-color: #ffffff;
		color:#fed065;
		cursor: pointer;
	}
	nav#main a{
		display: inline-block;/* box style로 변경*/
		color: inherit; /*글자색은 a tag를 감싼 곳에서 상속*/
		text-decoration: none;/* text에 언더라인 제거*/
	}
	
</style>
<h1 class="main">방명록 2021</h1>
<%-- 메뉴를 설정할때 사용하는 tag --%>
<%-- div 라는 tag사용하여 layout을 설정했는데 --%>
<%-- HTML 5에서는 Symatec(의미있는 이름으로) tag를 --%>
<%--사용하는 것을 권장한다 --%>
<nav id="main">
	<ul>
	<%--
	일반적으로 메뉴(내비게이션)등을 만들때
	해당메뉴로 클릭하면 다른 페이지로 점프하는 방식을
	가장 쉽게 구현하기 위하여 a tag를 사용한다
	
	a tag를 사용할 때 a tag의 기본속성을
	제거하고 새로운 속성을 부여하는 
	CSS코드를 추가한다
	
	이러한 방식이 번거로워서 아예 a tag를 사용하지 않고
	다른 종류의 tag를 사용하여 메뉴를 구성하기도 한다.
	
	여기서는 ul>li tag를 사용하여(추가)
	상단의 메뉴를 생성하였다
	
	a tag 를 사용하지 않고 메뉴등을 구성했을 때는
	스크립트를 사용하여 "메뉴 클릭 점프"기능을
	구현해야하는 문제가 발생한다
	
	최근에 유행하는 UI/UX는 그러한 스크립트를 사용해야 함에도 불구하고
	a tag 를 사용하지 않는 방식을 많이 사용한다
	
	스크립트를 사용하면 또다른 이점이 있는데
	메뉴와 관련된 부분을 스크립트에서 모아서 사용할 수 있고
	상태적으로 HTML코드에 직접 anchor를 설정하는 것보다
	본문코드가 간편해지기도 한다
	 --%>
		<li><a href="${rootPath}">Home</a></li>
		<li><a href="${rootPath}/notice">공지사항</a></li>
		<li>회사소개</li>
		<li>로그인</li>
		<li>회원가입</li>
	</ul>
</nav>
<script>
	/*
	HTML 문서를 DOM(document object model)이라고 한다
	tag로 둘러쌓인 모든속성은 하나의 객체가 된다
	
	HTML 문서의 모든 객체의 시작점 객체는 document
	*/
	
	document.querySelector("nav#main").addEventListener("click", function(ev){
		let text = ev.target.textContent;
		alert(text + "(가)이 클릭됨!")
		
		let url = "${rootPath}"
		if(text == "HOME"){
			url += "/"
		} else if(text == "공지사항") {
			url += "/notice"
		} else if(text == "회사소게") {
			url += "/profile"
		} else if(text == "로그인") {
			url += "/join"
		} else if(text == "회원가입") {
			url += "/login"
		}
		document.location.href = url;
	});
</script>




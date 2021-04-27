# Req And Res
* Request(요청), Response(응답)
* Run As/ Run on Server로 실행하면 톰캣이 작동되면서 현재 프로젝트를 웹으로 서비스를 하기 위해 시작된다.
* 웹브라우저에서 localhost:8080/Server_001_Hello와 같은 주로를 입력하고 엔터를 누르면
* localhost(내 컴퓨터)의 8080 Port에서 기다리고 있는 톰캣에서 요청한다
* 톰캣은 /Server_001_Hello라는 문자열을 보고 현재 프로젝트 중에 Server_001_Hello라는 프로젝트가 런되어 있는지 찾는다
* 있으면 프로젝트의 webapp폴더에서 index.htm, index.html,index.jsp파일을 순서대로 찾는다
* 있으면 파일을 읽어서 웹브라우저에 응답한다.
* 없으면 404 파일없음, (fileNot found) 오류메시지를 전송한다.
* localhost:8080/Server_001_Hello/index.html과 같은 방식으로 요청하는 걸로 약속되어 있다
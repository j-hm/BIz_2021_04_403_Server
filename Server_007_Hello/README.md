# SERVLET의 응답처리

## REQUEST와 RESPONSE
* REQUEST는 웹 브라우저에서 서버에 요청을 하는 행위
* RESPONSE는 서버가 웹 브라우저에게 응답을 하는 행위

## Request의 forword() / Response의 sendReDirect()
* req.의 forword()는 서버에 있는 jsp파일을 읽어서 렌더링을 수행한 후 웹 브라우저에게 전달하는 것
* resp.의 sendReDirect()는 서버가 다른 웹 브라우저에게 다른 요청 주소를 보내고 웹 브라우저가 그쪽 주소로 다시 요청을 보내도록 하는 것
(책임전가..ㅋㅋ)

## forword()와 sendReDirect()
* forword()는 클라이언트의 요청을 수행하여 결과를 알려주는 것까지 책임을 지는 방식
* forword()는 데이터를 처리하고, 화면 렌더링까지 수행
* sendReDirect()는 클라이언트의 요청을 서버의 다른 요청주소로 책임을 떠넘기는 방식
* 마치 웹 브라우저에 주소를 타이핑하여 입력하는 방식으로 요청을 전달만 한다
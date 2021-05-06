# WAS (Web Application Service)
* Web Application Server : Tomcat과 같은 서버 소프트웨어를 일컷는 말
* Web Application Service : 어떤 특정한 언어를 사용헤여 인터넷 환경에 작동되는 어플리케이션
* Web Service는 항상 Request를 받을 준비상태 있으며 언제든지 Web Browser에서 요청이 들어오면 그 요청이 무엇인지 파악하여 적절한 응답을 할 대기 상태로 있다.
* Web Service는 Client(Web Browser)의 요청이 있을 때만 반응을 시작한다.

## Client의 요청하기
* url을 통하여 : http://localhost:8080/book/rent와 같은 요청을 Web Browser의 주소창에 입력하는 방식
* Service를 실행하는 화면에서 Link(Anchor)를 클릭하기
* Service를 실행하는 화면에서 데이터를 input box에 입력하고 전송하기

## Link 클릭
* HTML 코드를 사용하여 파일을 만들고, 일단 클라이언트에게 먼저 보여주고, 클라이언트가 클릭하도록 하기
* anchor tag 를 사용하여 코드를 작성하기
* <a href='요청'>보여줄내용</a>

## 데이터를 input box에 입력하고 전송하기
* HTML코드를 사용하여 파일을 만들고, 클라이언트에게 보여주고, 클라이언트가 값을 입력하고 전송을 클릭하면 데이터와 함께 요청하기
* <form action ="요청"><input name ="변수이름"/></form>
* input  box에 입력하고 전송을 요청하면 요청?변수이름=값 형식으로 서버에 요청한다. 클라이언트가 입력한 데이터를 함께 서버로 전송하여 처리하도록한다.

## Server에서 처리하기
* 클라이언트의 요청이 오면 지정된 컨트롤러의 doGet()메서드가 먼저 반응한다.
* 또 다른 Sub요청을 분석하여 적절한 요청을 처리한다
* 좀 더 세밀한 처리가 필요할 경우 Service 클래스에게 요청을 하고, 결과를 리턴받는다
* 클라이언트에게 문자열, view 형식으로 보여주기를 준비한다
* 이때 보여주는 모든 형식은 HTML코딩 형식으로 만든다

## WAS 프로젝트에서 /webapp/WEB_INF/폴더
* MVC 패턴의 프로젝트에서는 모든 요청을 Controller 클래스에서 처리하고, 사용자에게 보여주는 jsp파일에서 처리하도록 작성을 한다. 
* 전통적인 WAS프로젝트에서는 /webapp폴더에 jsp파일을 저장하는데, webapp폴더에 저장된 jsp파일은 web browser에서 직접 호출하여 사용할 수 있다.
* jsp를 직접 호출하여 작동시키는 방식은 보안등의 문제, 대형 프로젝트의 작성을 어렵게 만드는 요인이다.
* MVC패턴에서는 jsp파일을 직접 호출하지 못하도록 한다.
* WEB_INF 폴더에서 views 폴더를 만들고 jsp를 저장하면 web browser에서 jsp를 직접 호출할 수 없게 된다. WEB_INF는 프로젝트의 Controller 클래스에서만 접근할 수 있도록 되어있다.
* jsp파일을 모두 WEB_INF 폴더 아래 두고 프로젝트를 진행한다
* MVC패턴에서는 개발자와 디자이너가 협업으르 쉽게 할 수 있도록 연산을 담당하는 Controller는 기능을 강화하고, jsp파일은 보여주는 용도로만 기능을 제한한다
* MVC패턴을 준수하면 프로젝트가 대형화될 수록 효과가 나타난다.
* Controller에서 WEB-INF폴더 아래의 jsp를 호출하려면 RequestDispatcher 클래스를 사용하여 접근한다.
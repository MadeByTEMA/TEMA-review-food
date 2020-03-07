# 37_3 - Application Server 구조로 변경: 통신 규칙2 추가 및 Servlet, DAO에 적용
 
1) 서버가 클라이언트에게 추가 데이터 입력을 요구할 수 있도록 통신 규칙을 변경하라.
규칙2) 사용자 입력을 포함하는 경우
```
[클라이언트]                                     [서버]
서버에 연결 요청     -------------->         연결 승인
명령(CRLF)            -------------->         명령처리
화면 출력             <--------------           응답(CRLF)
사용자 입력 요구     <--------------         !{}!(CRLF)
입력값(CRLF)         -------------->         입력 값 처리
화면 출력             <--------------         응답(CRLF)
사용자 입력 요구     <--------------         !{}!(CRLF)
입력값(CRLF)         -------------->         입력 값 처리
명령어 실행 완료     <--------------         !end!(CRLF)
서버와 연결 끊기
```
 
2) '통신 규칙2'에 따라 회원 번호를 입력 받을 수 있도록 ClientDetailServlet을 변경하라.
 
- tema.frr.chicken.servlet.ClientDetailServlet 변경
  - Servlet 인터페이스에 추가한 service(Scanner in, PrintStream out)을 구현한다.
  - '통신 규칙2'에 따라 클라이언트에게 상세 조회할 회원 번호를 요구한다.
  - '통신 규칙1'에 따라 응답한다.
- tema.frr.chicken.ServerApp 변경
  - '/client/detail' 명령을 처리할 서블릿을 맵에 추가한다.
 
3) '통신 규칙2'에 따라 회원을 입력 받을 수 있도록 ClientAddServlet을 변경하라.
 
- tema.frr.chicken.servlet.ClientAddServlet 변경
  - Servlet 인터페이스에 추가한 service(Scanner in, PrintStream out)을 구현한다.
  - '통신 규칙2'에 따라 클라이언트에게 새 회원 정보를 요구한다.
  - '통신 규칙1'에 따라 응답한다.
- tema.frr.chicken.ServerApp 변경
  - '/client/add' 명령을 처리할 서블릿을 맵에 추가한다.
 
4) '통신 규칙2'에 따라 회원을 변경할 수 있도록 ClientUpdateServlet을 변경하라.
 
- tema.frr.chicken.servlet.ClientUpdateServlet 변경
  - Servlet 인터페이스에 추가한 service(Scanner in, PrintStream out)을 구현한다.
  - '통신 규칙2'에 따라 클라이언트에게 회원 정보 변경을 요구한다.
  - '통신 규칙1'에 따라 응답한다.
- tema.frr.chicken.ServerApp 변경
  - '/client/update' 명령을 처리할 서블릿을 맵에 추가한다.
 
 
5) '통신 규칙2'에 따라 회원을 삭제할 수 있도록 ClientDeleteServlet을 변경하라.
 
- tema.frr.chicken.servlet.ClientDeleteServlet 변경
  - Servlet 인터페이스에 추가한 service(Scanner in, PrintStream out)을 구현한다.
  - '통신 규칙2'에 따라 클라이언트에게 회원 번호를 요구한다.
  - '통신 규칙1'에 따라 응답한다.
- tema.frr.chicken.ServerApp 변경
  - '/client/delete' 명령을 처리할 서블릿을 맵에 추가한다.
 
6) '통신 규칙2'에 따라 동작하도록 나머지 Servlet 클래스도 변경하라.
 
- tema.frr.chicken.servlet.ReviewBoardXxxServlet 변경
  - Servlet 인터페이스에 추가한 service(Scanner in, PrintStream out)을 구현한다.
  - '통신 규칙2'에 따라 변경한다.
  - '통신 규칙1'에 따라 응답한다.
- tema.frr.chicken.ServerApp 변경
- '/reviewboard/*' 명령을 처리할 서블릿을 맵에 추가한다.

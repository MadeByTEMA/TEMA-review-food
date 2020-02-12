# 32_4 - 서버에 데이터를 요청하는 기능을 추가하기

1) 31번 프로젝트에서 Client 클래스를 가져오라.

- tema.frr.chicken.domain 패키지 생성한다.
- Client.java 가져온다.

2) 31번 프로젝트에서 고객 관리를 처리하는 Command 객체 가져오라.

- tema.frr.chicken.handler 패키지 생성한다.
- ClientXxxCommand.java 클래스 가져온다. 

3) Command 객체가 서버와 통신할 수 있도록 입출력 도구를 제공하라.

- ClientApp.java 변경
  - 서버와 연결하는 코드를 적용한다.
  - 서버와 통신할 수 있는 입출력 도구를 ClientXxxCommand 객체에 제공한다.
  
4) ClientListCommand 가 작업할 때 서버와 통신하도록 처리하라.

- ClientListCommand.java 변경
  - 서버의 입출력 도구를 받을 수 있도록 생성자를 변경한다.
  - 데이터를 읽고 쓸 때 서버에 요청하도록 execute()를 변경한다.

5) ClientAddCommand 가 작업할 때 서버와 통신하도록 처리하라.

- ClientAddCommand.java 변경
  - 서버의 입출력 도구를 받을 수 있도록 생성자를 변경한다.
  - 데이터를 읽고 쓸 때 서버에 요청하도록 execute()를 변경한다.

6) ClientDetailCommand 가 작업할 때 서버와 통신하도록 처리하라.

- ClientDetailCommand.java 변경
  - 서버의 입출력 도구를 받을 수 있도록 생성자를 변경한다.
  - 데이터를 읽고 쓸 때 서버에 요청하도록 execute()를 변경한다.
  
7) ClientUpdateCommand 가 작업할 때 서버와 통신하도록 처리하라.

- ClientUpdateCommand.java 변경
  - 서버의 입출력 도구를 받을 수 있도록 생성자를 변경한다.
  - 데이터를 읽고 쓸 때 서버에 요청하도록 execute()를 변경한다.
  
8) ClientDeleteCommand 가 작업할 때 서버와 통신하도록 처리하라.

- ClientDeleteCommand.java 변경
  - 서버의 입출력 도구를 받을 수 있도록 생성자를 변경한다.
  - 데이터를 읽고 쓸 때 서버에 요청하도록 execute()를 변경한다.

9) WritingReviewXxxCommand 가 작업할 때 서버와 통신하도록 처리하라.

- WritingReviewXxxCommand.java 변경
  - 서버의 입출력 도구를 받을 수 있도록 생성자를 변경한다.
  - 데이터를 읽고 쓸 때 서버에 요청하도록 execute()를 변경한다.
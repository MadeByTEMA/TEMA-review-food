# 32_4 - 클라이언트의 데이터 관리 요청을 처리하기 

1) 서비스를 시작할 때 클라이언트의 연결을 기다리는 코드를 추가하라.

- ServerApp.java 변경
  - ServerSocket을 준비한다.
  - 클라이언트 연결을 준비한다.
  
2) 클라이언트의 고객 목록 요청(/client/list)을 처리하라.

- ServerApp.java 변경
  - processRequest() 메서드 변경
- ServerAppTest.java 추가
  - 서버의 응답 기능을 테스트 한다.
- Clinet.java 변경
  - 통신 테스트 할 때 고객 필드 정보를 확인할 수 있도록 toString()을 오버라이딩 한다.

3) 클라이언트의 고객 등록 요청(/client/add)을 처리하라.

- ServerApp.java 변경
  - processRequest() 메서드 변경

4) 클라리언트의 고객 조회 요청(/client/detail)을 처리하라.

- ServerApp.java 변경
  - processRequest() 메서드 변경
  
5) 클라리언트의 고객 변경 요청(/client/update)을 처리하라.

- ServerApp.java 변경
  - processRequest() 메서드 변경  
  
6) 클라리언트의 고객 삭제 요청(/client/delete)을 처리하라.

- ServerApp.java 변경
  - processRequest() 메서드 변경  

7) 클라리언트의 후기 관리 요청(/writingReview/*)을 처리하라.

- ServerApp.java 변경
  - processRequest() 메서드 변경  

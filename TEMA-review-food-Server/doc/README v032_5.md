# 32_5 - 특정 기능을 수행하는 코드를 메서드로 분리하기 

1) 클라이언트의 요청을 처리하는 코드를 기능별로 분리하라. 

- ServerApp.java 변경
  - if~ else~ 분기문에 작성한 코드를 별도의 메서드로 분리하여 정의한다.
  - listClient() : 회원 목록 데이터 요청 처리
  - addClient() : 회원 데이터 등록 요청 처리
  - detailClient() : 회원 조회 요청 처리
  - updateClient() : 회원 변경 요청 처리
  - deleteClient() : 회원 삭제 요청 처리
  - listWritingReview() : 후기 목록 데이터 요청 처리
  - addWritingReview() : 후기 데이터 등록 요청 처리
  - detailWritingReview() : 후기 조회 요청 처리
  - updateWritingReview() : 후기 변경 요청 처리
  - deleteWritingReview() : 후기 삭제 요청 처리

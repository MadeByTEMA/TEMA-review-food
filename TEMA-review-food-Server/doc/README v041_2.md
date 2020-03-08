# 41_2 - 트랜잭션 관리자를 사용하는 코드를 캡슐화하기
 
1) 트랜잭션 관리자를 사용하는 코드를 캡슐화하여 별도의 클래스로 분리하라.
 
- tema.frr.sql.TransactionTemplate 추가
  - 트랜잭션 관리자를 사용하는 코드를 메서드로 정의한다.
- tema.frr.sql.TransactionCallback 인터페이스 추가
  - TransactionTemplate이 작업을 실행할 때 호출할 메서드 규칙을 정의한다.
  - 트랜잭션 작업은 이 규칙에 따라 작성해야 한다.
 
2) 트랜잭션을 사용할 곳에 TransactionTemplate을 적용하라.
 
- tema.frr.chicken.servlet.PhotoBoardAddServlet 변경
  - PlatformTransactionManager를 직접 사용하는 대신에 TransactionTemplate을 사용한다.
- tema.frr.chicken.servlet.PhotoBoardUpdateServlet 변경
  - PlatformTransactionManager를 직접 사용하는 대신에 TransactionTemplate을 사용한다.
- tema.frr.chicken.servlet.PhotoBoardDeleteServlet 변경
  - PlatformTransactionManager를 직접 사용하는 대신에 TransactionTemplate을 사용한다.

# 40_4 - Connection을 스레드에 보관하기: 트랜잭션 관리자 도입하기
 
1) 트랜잭션 제어 코드를 캡슐화 하라.
 
- tema.frr.sql.PlatformTransactionManager 추가
  - 트랜잭션을 시작시키고, 커밋/롤백하는 메서드를 정의한다.
 
 
2) PhotoBoardAddServlet에 트랜잭션 관리자를 적용하라.
 
- tema.frr.chicken.servlet.PhotoBoardAddServlet 변경
  - PlatformTransactionManager를 주입 받는다.
  - 트랜잭션 관리자를 통해 트랜잭션을 제어한다.
 
3) PhotoBoardUpdateServlet에 트랜잭션 관리자를 적용하라.
 
- tema.frr.chicken.servlet.PhotoBoardUpdateServlet 변경
  - PlatformTransactionManager를 주입 받는다.
  - 트랜잭션 관리자를 통해 트랜잭션을 제어한다.
 
4) PhotoBoardDeleteServlet에 트랜잭션 관리자를 적용하라.
 
- tema.frr.chicken.servlet.PhotoBoardDeleteServlet 변경
  - PlatformTransactionManager를 주입 받는다.
  - 트랜잭션 관리자를 통해 트랜잭션을 제어한다.
 
5) DataLoaderListener에서 트랜잭션 관리자를 준비하라.
 
- tema.frr.chicken.DataLoaderListener 변경
  - PlatformTransactionManager 객체를 준비한다.
 
6) 트랜잭션 관리자를 서블릿에 주입하라.
 
- tema.frr.chicken.ServerApp 변경
  - 맵에서 PlatformTransactionManager 객체를 꺼내 서블릿 객체에 주입한다.

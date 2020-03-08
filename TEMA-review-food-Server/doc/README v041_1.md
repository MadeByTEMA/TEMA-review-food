# 41_1 - Connection Pool 도입하기
 
1) DB 커넥션 풀 객체를 생성하라.
 
- tema.frr.sql.DataSource 추가
  - ConnectionFactory를 DataSource로 이름을 변경한다.
  - JDBC API에서는 커넥션 객체를 생성하고 관리하는 역할자를 DataSource로 정의하였다.
  - 그래서 이 이름과 같게 만들자.
  - ConnectionFactory + Pooling 기능 = DataSource
 
2) PlatformTransactionManager 를 변경하라.
 
- tema.frr.sql.PlatformTransactionManager 변경
  - ConnectionFactory 대신 DataSource를 사용하도록 변경한다.
 
3) DataSource를 사용하도록 DAO를 변경하라.
 
- tema.frr.chicken.dao.mariadb.XxxDaoImpl 변경
  - ConnectionFactory 대신 DataSource를 사용하도록 변경한다.
 
4) DataSource를 DAO에 주입하라.
 
- tema.frr.chicken.DataLoaderListener 변경
  - ConnectionFactory 대신 DataSource 객체를 생성한다.
  - DAO에 DataSource를 주입한다.
  - 애플리케이션이 종료될 때 모든 DB 커넥션을 닫는다.
 
5) 클라이언트 요청을 처리한 후 Connection을 닫지 말고 반납하라.
 
- tema.frr.chicken.ServerApp 변경
  - 클라이언트에게 응답한 후 스레드에서 커넥션 객체를 제거한다.
  - 제거된 커넥션 객체는 재사용하기 위해 닫지 않는다.

# 36_1 - DBMS를 도입하여 데이터 관리를 맡기기

1) Client, WritingReview 변경하라.
- Clinet 컬럼 추가한다.
- WritingReview 컬럼 추가한다.
- WritingReview 변경한다.

2) 애플리케이션에서 사용할 사용자와 데이터베이스를 MariaDB에 추가한다.

3) 프로젝트에 `MariaDB` JDBC 드라이버를 추가하라.

4) MariaDB에서 제공하는 Proxy를 사용하여 DBMS와 연동하여 데이터 처리 작업을 수행할 DAO를 정의하라.

- tema.frr.chicken.dao.mariadb 패키지 생성한다.
- tema.frr.chicken.dao.mariadb.ClientDaoImpl 추가한다.
- tema.frr.chicken.dao.mariadb.ReviewBoardDaoImpl 추가한다.

5) Command 객체의 기존 DAO를 MariaDB 연동 DAO로 교체하라. 

- tema.frr.chicken.ClientApp 변경한다.

6) DBMS 연동에 맞춰서 Command 객체를 변경하라.

- tema.frr.chicken.handler.XxxAddCommand 변경한다.
- tema.frr.chicken.handler.XxxUpdateCommand 변경한다.
- tema.frr.chicken.handler.XxxDeleteCommand 변경한다.
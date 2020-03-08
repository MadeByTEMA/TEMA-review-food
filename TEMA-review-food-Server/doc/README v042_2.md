# 42_2 - SQL 삽입 공격과 자바 시큐어 코딩: PreparedStatement로 전환하기
 
1) 기존의 Statement 객체를 PreparedStatement 객체로 모두 바꿔라.
 
- tema.frr.chicken.dao.mariadb.XxxDaoImpl 변경
  - Statement를 PreparedStatement 로 변경한다.
 
2) SQL 삽입 공격을 통해 유효하지 않은 사용자 정보로 로그인 해 보라.

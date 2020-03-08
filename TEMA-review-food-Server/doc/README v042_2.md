 # 42_1 - SQL 삽입 공격과 자바 시큐어 코딩: 사용자 로그인 기능 추가
 
1) 사용자 로그인 기능을 만들라.
 
- frr_clinet 테이블의 암호 초기화
  - 테스트하기 위해 모든 회원의 암호를 '1111'로 초기화 한다.
  - update frr_clinet set pwd=password('1111') 실행
- tema.frr.chicken.dao.ClientDao 변경
  - 이메일과 암호를 가지고 사용자를 조회하는 메서드를 추가한다.
  - Client findByEmailAndPassword(String email, String password)
- tema.frr.chicken.dao.mariadb.ClientDaoImpl 변경
  - ClientDao에 추가한 메서드를 구현한다.
  - insert(), update()의 SQL 문에서 암호를 입력하거나 변경할 때
  password() SQL 함수로 인코딩하도록 SQL 문을 변경한다.
- tema.frr.chicken.servlet.LoginServlet 추가
  - 사용자로부터 이메일과 암호를 입력받아 인증을 수행한다.
- tema.frr.chicken.ServerApp 변경
  - "/auth/login" 명령을 처리할 LoginServlet 객체를 맵에 추가한다.
 
2) SQL 삽입 공격을 통해 유효하지 않은 사용자 정보로 로그인 해 보라.
 
분명히 잘못된 암호를 넣었는데도 불구하고 로그인에 성공했다.
이것이 SQL 삽입 공격이다.

# 40_2 - Connection을 스레드에 보관하기: 한 스레드에서 Connection 을 여러 번 사용할 때 발생하는 문제점 해결하기
 
1) Connection의 일을 대행할 프록시를 정의하라.
 
- tema.frr.sql.ConnectionProxy 추가
  - close()를 구현한다.
  - 호출되면 아무런 일을 하지 않게 한다.
  - 즉 커넥션을 닫지 않는다.
  - realClose() 추가한다.
  - 실제 커넥션을 닫는 일을 한다.
  - 나머지 메서드는 원래 Connection 객체에 위임한다.
  - eclipse / 소스창의 컨텍스트 메뉴 / source /generate delegate methods... 실행
  
2) ConnectionFactory가 ConnectionProxy 객체를 리턴하게 하라.
 
- tema.frr.util.ConnectionFactory 변경
  - getConnection() 변경
  - 원래의 Connection 객체 대신에 ConnectionProxy를 리턴한다.
 
3) 스레드에서 Connection을 제거하기 전에 서버와의 연결을 끊어라.
 
- tema.frr.util.ConnectionFactory 변경
  - removeConnection()이 스레드에서 제거한 Connection을 리턴하게 변경한다.
- tema.frr.chicken.ServerApp 변경
  - ConnectionFactory에서 리턴 받은 Connection 객체에 대해
  realClose()를 호출한다.

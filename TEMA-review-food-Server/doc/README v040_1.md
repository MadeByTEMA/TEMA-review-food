# 40_1 - Connection을 스레드에 보관하기: ThreadLocal을 사용하여 스레드에 값 보관하기
 
1) 커넥션 팩토리에서 생성한 Connection 객체를 스레드에 보관하라.
 
- tema.frr.util.ConnectionFactory 변경
  - getConnection() 변경
    - 스레드에 보관된 Connection 객체가 없다면, 새로 생성하여 리턴한다.
  - 새로 생성한 Connection 객체는 스레드에 보관한다.
  - 스레드에 보관된 Connection 객체가 있다면 그 객체를 꺼내 리턴한다.
  
#### 문제점
 
- 현재 스레드풀(ExecutorService)을 이용하여 스레드를 관리하고 있다.
- 스레드를 사용한 후(클라이언트 요청에 응답을 완료한 후)에
  스레드를 버리지 않고 풀에 보관했다가
  다음 클라이언트 요청에 재사용한다.
- DAO가 사용하는 Connection 객체는 스레드에 보관한다.
- DAO의 메서드(예: findAll(), insert() 등)에서 Connection을 사용한 후에 닫는다.
- 따라서 스레드에 보관한 Connection은 DAO 작업이 끝난 후 닫힌 상태가 된다.
- 그래서 다음 클라이언트 요청을 처리하기 위해 스레드를 재사용할 때
  그 스레드에 있는 Connection은 닫힌 Connection이기 때문에
  DAO가 작업할 때 오류가 발생한다.
 
#### 해결책
 
- 클라이언트에게 응답을 완료한 후에 스레드에 보관된 Connection 객체를 제거한다.
- 다음에 클라이언트 요청을 처리하기 위해 같은 스레드가 사용되더라도
  이미 그 스레드에는 Connection 객체가 없기 때문에
  ConnectionFactory는 새 Connection을 만들어 리턴할 것이다.
 
2) 클라이언트에 응답을 한 후 스레드에 보관된 Connection 객체를 제거하라.
 
- tema.frr.util.ConnectionFactory 변경
  - Thread에 보관된 Connection 객체를 제거하는 메서드를 추가한다.
  - removeConnection()
- tema.frr.chicken.DataLoaderListener 변경
  - ServerApp에서 ConnectionFactory를 사용할 수 있도록 맵에 보관하여 리턴한다.
- tema.frr.chicken.ServerApp 변경
  - 클라이언트 요청을 처리한 후에
    ConnectionFactory를 통해 Thread에서 Connection을 제거한다.

# 33 - 동일한 자원으로 더 많은 클라이언트의 요청을 처리하는 방법
 
1) `Stateful` 통신 방식을 `Stateless` 통신 방식으로 바꿔라.
 
- tema.frr.chicken.ServerApp을 변경한다.
  - 클라이언트와 연결되면 한 번의 요청을 처리한 후 즉시 연결을 끊는다.

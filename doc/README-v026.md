# 26 - `커맨드(Command)` 디자인 패턴을 적용하기

1) 메서드를 호출하는 쪽과 실행 쪽 사이의 규칙을 정의하라.

- Command.java
    - `App` 클래스와 명령을 처리하는 클래스 사이의 호출 규칙을 정의한다.

2) 명령을 처리하는 각 메서드를 객체로 분리하라.

- ClientHandler.java
    - 수업 CRUD 각 기능을 `Command` 규칙에 따라 객체로 분리한다.
- WritingReviewHandler.java
    - 수업 CRUD 각 기능을 `Command` 규칙에 따라 객체로 분리한다.
- App.java (App.java.01)
    - 명령어가 입력되면 `Command` 규칙에 따라 객체를 실행한다.

3) `Map`으로 `Command` 객체를 관리하라.

- App.java
    - 명령어를 `key`, `Command` 객체를 `value`로 하여 Map에 저장한다.
    - 각 명령에 대해 조건문으로 분기하는 부분을 간략하게 변경한다.
    
4) '/hello' 명령을 추가하라.

'''
명령> hello
이름? 홍길동
홍길동님 반갑습니다.


명령 >

5) '/compute/plus' 명령을 추가하라.

'''
명령> /compute/plus
수1? 100
수2? 200
계산결과는 300 입니다.


명령 >
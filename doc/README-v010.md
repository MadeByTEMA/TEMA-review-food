# 10 - 클래스로 메서드를 분류하기

1) 회원 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라.

- ClientHandler.java
    - 회원 관리와 관련된 메서드를 담을 클래스를 만든다.
    - `App.java` 에서 회원관리와 관련된 변수와 메서드를 `ClientHandler` 클래스로 옮긴다.
- App.java (App.java.01)
    - `clientHandler` 클래스 사용한다.


2) 후기 작성 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라.

- WritingReviewHandler.java
    - 후기 작성 관리와 관련된 메서드를 담을 클래스를 만든다.
    - `App.java` 에서 후기 작성 관리와 관련된 변수와 메서드를 `WritingReviewHandler` 클래스로 옮긴다.
- App.java (App.java.02)
    - `WritingReviewHandler` 클래스 사용한다.
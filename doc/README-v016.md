# 16 - UI 코드와 데이터 처리 코드를 분리하기
 
1) ClientHandler에서 데이터 처리 코드를 분리하라.

- ClientList.java
    - `ClientHandler`에서 데이터 처리 코드를 이 클래스로 옮긴다.
    - 고객 데이터 배열을 리턴하는 toArray() 메서드를 정의한다.
    - 고객 데이터를 저장하는 add() 메서드를 정의한다.
    - 기본 생성자와 배열의 초기 크기를 설정하는 생성자를 정의한다.  
- ClientHandler.java
    - `ClientList` 클래스를 사용하여 데이터를 처리한다.

2) WritingReviewHandler에서 데이터 처리 코드를 분리하라.

- WritingReviewList.java
    - `WritingReviewHandler`에서 데이터 처리 코드를 이 클래스로 옮긴다.
    - 후기 작성 데이터 배열을 리턴하는 toArray() 메서드를 정의한다.
    - 후기 작성 데이터를 저장하는 add() 메서드를 정의한다.
    - 기본 생성자와 배열의 초기 크기를 설정하는 생성자를 정의한다.  
- WritingReviewHandler.java
    - `WritingReviewList` 클래스를 사용하여 데이터를 처리한다.
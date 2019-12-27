# 14 - 생성자가 필요한 이유

1) 핸들러 객체의 필수 입력 값인 keyboard를 반드시 설정하게 만들라!

- ClientHandlerjava
    - 기본 생성자 대신에 파라미터로 keyboard를 받는 생성자를 추가한다.
- WritingReviewHandler.java
    - 기본 생성자 대신에 파라미터로 keyboard를 받는 생성자를 추가한다.
- App.java
    - 핸들러의 인스턴스를 생성할 때 파라미터의 값으로 keyboard 객체를 넘긴다.

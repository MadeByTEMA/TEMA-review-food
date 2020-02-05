# 28_2 - CSV 문자열을 객체로 전환하는 기능을 도메인 객체로 이전 

1) 회원 데이터를 CSV 문자열로 다루는 코드를 Client클래스로 옮겨라.  

- Client.java
  - CSV 문자열을 가지고 Client 객체를 생성하는 valueOf() 를 추가한다.
  - Client 객체를 가지고 CSV 문자열을 리턴하는 toCsvString() 를 추가한다.
- App.java
  - loadClientData() 를 변경한다.
  - saveClientData() 를 변경한다.  

2) 후기 데이터를 CSV 문자열로 다루는 코드를 WritingReview클래스로 옮겨라.  

- WritingReview.java
  - CSV 문자열을 가지고 WritingReview 객체를 생성하는 valueOf() 를 추가한다.
  - WritingReview 객체를 가지고 CSV 문자열을 리턴하는 toCsvString() 를 추가한다.
- App.java
  - loadWritingReviewData() 를 변경한다.
  - saveWritingReviewData() 를 변경한다.
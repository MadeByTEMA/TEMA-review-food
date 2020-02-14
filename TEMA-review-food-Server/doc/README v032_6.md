# 32_6 - 커맨드 패턴을 적용하여 요청 처리 메서드를 객체화 하기 

1) 커맨드 패턴의 인터페이스 정의하라.

- tema.frr.chicken.servlet 패키지를 생성한다.
- tema.frr.chicken.servlet.Servlet 인터페이스를 정의한다.

2) 각각의 요청 처리 메서드를 인터페이스 규칙에 따라 클래스를 정의하라.
 
- listClient()를 ClientListServlet 클래스로 정의한다.
- addClient()를 ClientAddServlet 클래스로 정의한다.
- detailClient()를 ClientDetailServlet 클래스로 정의한다.
- updateClient()를 ClientUpdateServlet 클래스로 정의한다.
- deleteClient()를 ClientDeleteServlet 클래스로 정의한다.
- listWritingReview()를 WritingReviewListServlet 클래스로 정의한다.
- addWritingReview()를 WritingReviewAddServlet 클래스로 정의한다.
- detailWritingReview()를 WritingReviewDetailServlet 클래스로 정의한다.
- updateWritingReview()를 WritingReviewUpdateServlet 클래스로 정의한다.
- deleteWritingReview()를 WritingReviewDeleteServlet 클래스로 정의한다.

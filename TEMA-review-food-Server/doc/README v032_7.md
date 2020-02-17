# 32_7 - 데이터 처리 코드를 별도의 클래스로 정의하여 객체화 시키기

1) 고객 데이터를 처리하는 DAO 클래스를 정의하라.

- tema.frr.chicken.dao 패키지를 생성한다.
- tema.frr.chicken.ClientObjectFileDao 클래스를 정의한다.

2) ClientObjectFileDao 객체를 적용하라.

- tema.frr.chicken.DataLoaderListener 를 변경한다.
  - 고객 데이터를 로딩하고 저장하는 기존 코드를 제거한다.
  - 대신에 ClientObjectFileDao 객체를 생성한다.
- tema.frr.chicken.ServerApp 을 변경한다.
  - Map에서 ClientObjectFileDao를 꺼내 관련 커맨드 객체에 주입한다.
- ClientXxxServlet 을 변경한다.
  - 생성자에서 List 객체를 받는 대신에 ClientObjectFileDao 객체를 받는다.
  - 데이터를 저장하고, 조회하고, 변경하고, 삭제할 때 ClientObjectFileDao 객체를 통해 처리한다.
  
  
3) 후기 데이터를 처리하는 DAO 클래스를 정의하고 적용하라.

- tema.frr.chicken.WritingReviewObjectFileDao 클래스를 정의한다.
- tema.frr.chicken.DataLoaderListener 를 변경한다.
  - 후기 데이터를 로딩하고 저장하는 기존 코드를 제거한다.
  - 대신에 WritingReviewObjectFileDao 객체를 생성한다.
- tema.frr.chicken.ServerApp 을 변경한다.
  - Map에서 WritingReviewObjectFileDao를 꺼내 관련 커맨드 객체에 주입한다.
- WritingReviewXxxServlet 을 변경한다.
  - 생성자에서 List 객체를 받는 대신에 WritingReviewObjectFileDao 객체를 받는다.
  - 데이터를 저장하고, 조회하고, 변경하고, 삭제할 때 WritingReviewObjectFileDao 객체를 통해 처리한다.

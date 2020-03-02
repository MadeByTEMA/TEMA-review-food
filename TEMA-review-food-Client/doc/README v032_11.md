# 32_11 - 서버에서 제공한 프록시 객체를 사용하여 데이터를 처리하기

1) 서버 프로젝트(32_11)에서 DAO 프록시 클래스를 가져오라.

- tema.frr.chicken.dao.XxxDao 인터페이스를 가져온다.
- tema.frr.chicken.dao.proxy 패키지와 그 하위 클래스를 모두 가져온다.

2) ClientXxxCommand 객체가 ClientDaoProxy 객체를 사용하여 데이터를 처리하게 하라.

- tema.frr.chicken.handler.ClientXxxCommand 클래스를 변경한다.
  - 입출력 스트림 필드를 제거한다.
  - 생성자에서 프록시 객체를 받는다.
  - 프록시 객체를 사용하여 데이터를 처리한다.
- tema.frr.chicken.ClientApp 변경한다.
  - ClientDaoProxy 객체를 생성한다.
  - ClientXxxCommand 객체에 주입한다.

3) WritingReviewXxxCommand 객체가 WritingReviewDaoProxy 객체를 사용하여 데이터를 처리하게 하라.

- tema.frr.chicken.handler.WritingReviewXxxCommand 클래스를 변경한다.
  - 입출력 스트림 필드를 제거한다.
  - 생성자에서 프록시 객체를 받는다.
  - 프록시 객체를 사용하여 데이터를 처리한다.
- tema.frr.chicken.ClientApp 변경한다.
  - WritingReviewDaoProxy 객체를 생성한다.
  - WritingReviewXxxCommand 객체에 주입한다.

# 32_8 - DAO 클래스의 공통점을 뽑에 수퍼 클래스로 정의하기(generalization 수행하기)

1) DAO의 공통점을 뽑아 수퍼 클래스로 정의하라.

- tema.frr.chicken.dao.AbstractObjectFileDao 클래스를 생성한다.

2) ClientObjectFileDao가 위에서 정의한 클래스를 상속 받도록 변경하라.

- tema.frr.chicken.dao.ClientObjectFileDao 변경한다.
  - 상속 받은 필드와 메서드를 사용한다.
  - indexOf()를 오버라이딩 한다.

3) WritingReviewObjectFileDao가 위에서 정의한 클래스를 상속 받도록 변경하라.

- tema.frr.chicken.dao.WritingReviewObjectFileDao를 변경한다.
  - 상속 받은 필드와 메서드를 사용한다.
  - indexOf()를 오버라이딩 한다.
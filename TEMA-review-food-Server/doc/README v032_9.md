# 32_9 - 파일에 데이터를 저장할 때 JSON 형식을 사용하기

1) JSON 형식으로 데이터를 저장하고 로딩할 수퍼 클래스를 정의하라.

- tema.frr.chicken.dao.json 패키지를 생성한다.
- tema.frr.chicken.dao.json.AbstractJsonFileDao 클래스를 생성한다.

2) ClientObjectFileDao가 위에서 정의한 클래스를 상속 받도록 변경하라.

- tema.frr.chicken.dao.ClientJsonFileDao 변경한다.
  - 상속 받은 필드와 메서드를 사용한다.
  - indexOf()를 오버라이딩 한다.

3) WritingReviewJsonFileDao가 위에서 정의한 클래스를 상속 받도록 변경하라.

- tema.frr.chicken.dao.WritingReviewJsonFileDao 변경한다.
  - 상속 받은 필드와 메서드를 사용한다.
  - indexOf()를 오버라이딩 한다.

4) XxxObjectFileDao 대신 XxxJsonFileDao를 사용하도록 서블릿 클래스를 변경하라.

- tema.frr.chicken.servlet.ClientXxxServlet 변경한다.
- tema.frr.chicken.servlet.WritingReviewXxxServlet 변경한다.

5) 애플리케이션이 시작할 때 XxxObjectFileDao 대신 XxxJsonFileDao를 준비하라.

- tema.frr.chicken.DataLoaderListener 변경한다.

6) XxxObjectFileDao 대신 XxxJsonFileDao를 서블릿 객체에 주입하라.

- tema.frr.chicken.ServerApp 변경한다.

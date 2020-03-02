# 32_10 - 인터페이스를 이용하여 DAO 호출 규칙을 통일하기
 
1) ClientXxxServlet이 사용할 DAO 호출 규칙을 정의하고 구현하라.
 
- tema.frr.chicken.dao.ClientDao 인터페이스 생성한다.
- tema.frr.chicken.dao.ClientObjectFileDao 클래스를 변경한다.
  - ClientDao 인터페이스를 구현한다.
- tema.frr.chicken.dao.json.ClientJsonFileDao 클래스를 변경한다.
  - ClientDao 인터페이스를 구현한다.
- tema.frr.chicken.servlet.ClientXxxServlet 클래스를 변경한다.
  - DAO 레퍼런스 타입을 ClientDao 인터페이스로 변경한다.
- tema.frr.chicken.DataLoaderListener 변경한다.
- tema.frr.chicken.ServerApp 변경한다.
 
2) WritingReviewXxxServlet이 사용할 DAO 호출 규칙을 정의하고 구현하라.
 
- tema.frr.chicken.dao.WritingReviewDao 인터페이스 생성한다.
- tema.frr.chicken.dao.WritingReviewObjectFileDao 클래스를 변경한다.
  - WritingReviewDao 인터페이스를 구현한다.
- tema.frr.chicken.dao.json.WritingReviewJsonFileDao 클래스를 변경한다.
  - WritingReviewDao 인터페이스를 구현한다.
- tema.frr.chicken.servlet.WritingReviewXxxServlet 클래스를 변경한다.
  - DAO 레퍼런스 타입을 WritingReviewDao 인터페이스로 변경한다.
- tema.frr.chicken.DataLoaderListener 변경한다.
- tema.frr.chicken.ServerApp 변경한다.
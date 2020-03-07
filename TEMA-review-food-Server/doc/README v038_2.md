# 38_2 - 트랜잭션 적용 전: 사진 게시글에 첨부파일 추가하기
 
1) `수업 사진 게시판`에 사진 파일을 첨부하는 기능을 추가하라.
 
- tema.frr.chicken.domain.PhotoFile 추가
  - 사진 파일의 타입을 정의한다.
- tema.frr.chicken.dao.PhotoFileDao 인터페이스 추가
  - 사진 파일의 CRUD 관련 메서드 호출 규칙을 정의한다.
- tema.frr.chicken.dao.mariadb.PhotoFileDaoImpl 추가
  - PhotoFileDao 인터페이스를 구현한다.
- tema.frr.chicken.DataLoaderListener 변경
  - PhotoFileDao 객체를 생성한다.
 
 
2) '/photoboard/add' 명령을 처리하라.
 
사진 게시글을 입력할 때 사진 파일을 첨부할 수 있게 변경한다.
 
- tema.frr.chicken.dao.mariadb.PhotoBoardDaoImpl 변경
  - insert() 메서드를 변경한다.
  - insert 한 후에 자동 증가 PK 값을 리턴 받는다.
- tema.frr.chicken.servlet.PhotoBoardAddServlet 변경
  - ReviewBoardDao 객체를 주입 받아 수업 번호의 유효성을 검사한다.
  - 사진 게시글을 입력 받을 때 첨부 파일도 입력 받는다.
- tema.frr.chicken.ServerApp 변경
  - `PhotoBoardAddServlet` 객체에 ReviewBoardDao와 PhotoFileDao 객체를 주입한다.
  
  
3) '/photoboard/detail' 명령을 처리하라.
 
사진 게시글을 출력할 때 첨부 파일 목록도 함께 출력한다.
 
- tema.frr.chicken.dao.PhotoFileDao 인터페이스 변경
  - 사진 파일 목록을 리턴하는 메서드를 추가한다.
  - findAll(int boardNo)
- tema.frr.chicken.dao.mariadb.PhotoFileDaoImpl 변경
  - PhotoFileDao 인터페이스에 추가된 메서드를 구현한다.
- tema.frr.chicken.servlet.PhotoBoardDetailServlet 변경
  - PhotoFileDao 의존 객체를 주입받는다.
  - 사진 게시글 다음에 첨부파일 목록을 출력한다.
- tema.frr.chicken.ServerApp 변경
  - `PhotoBoardDetailServlet` 객체에 PhotoFileDao 객체를 주입한다.
 
 
4) PhotoFile 객체의 생성자 및 셋터의 활용
 
- 인스턴스의 초기 값을 설정할 수 있는 생성자를 추가한다.
 
생성자를 통해 인스턴스의 초기 값을 설정하기 I:
- tema.frr.chicken.domain.PhotoFile 변경
  - PhotoFile(filepath, boardNo) 생성자 추가한다.
- tema.frr.chicken.servlet.PhotoBoardAddServlet 변경
  - PhotoFile(filepath, boardNo) 생성자를 사용한다.
 
생성자를 통해 인스턴스의 초기 값을 설정하기 II:
- tema.frr.chicken.domain.PhotoFile 변경
  - PhotoFile(int no, filepath, boardNo) 생성자 추가한다.
- tema.frr.chicken.dao.mariadb.PhotoFileDaoImpl 변경
  - PhotoFile(no, filepath, boardNo) 생성자를 사용한다.
 
셋터 메서드를 통해 인스턴스의 초기 값을 설정하기:
- tema.frr.chicken.domain.PhotoFile 변경
  - 셋터 메서드가 인스턴스 주소를 리턴하게 변경한다.
- tema.frr.chicken.servlet.PhotoBoardAddServlet 변경
  - PhotoFile 객체를 만들 때 셋터 메서드로 값을 설정한다.
- tema.frr.chicken.dao.mariadb.PhotoFileDaoImpl 변경
  - PhotoFile 객체를 만들 때 셋터 메서드로 값을 설정한다.
 
 
5) '/photoboard/update' 명령을 처리하라.
 
사진 게시글을 변경할 때 첨부 파일도 변경한다.
 
- tema.frr.chicken.dao.PhotoFileDao 인터페이스 변경
  - 사진 파일을 삭제하는 메서드를 추가한다.
  - deleteAll(int boardNo)
- tema.frr.chicken.dao.mariadb.PhotoFileDaoImpl 변경
  - PhotoFileDao 인터페이스에 추가된 메서드를 구현한다.
- tema.frr.chicken.servlet.PhotoBoardUpdateServlet 변경
  - 사진 게시글의 첨부파일을 변경한다.
- tema.frr.chicken.ServerApp 변경
  - `PhotoBoardUpdateServlet` 객체에 PhotoFileDao 객체를 주입한다.
 
 
6) '/photoboard/delete' 명령을 처리하라.
 
사진 게시글을 삭제할 때 첨부 파일도 삭제한다.
 
- tema.frr.chicken.servlet.PhotoBoardDeleteServlet 변경
  - 첨부 파일 삭제를 할 때 사용할 PhotoFileDao 객체를 주입 받는다.
  - 사진 게시글을 삭제하기 전에 첨부 파일을 먼저 삭제한다.
  - 그런 후 사진 게시글을 삭제한다.
- tema.frr.chicken.ServerApp 변경
  - `PhotoBoardDeleteServlet` 객체에 PhotoFileDao 객체를 주입한다.
 

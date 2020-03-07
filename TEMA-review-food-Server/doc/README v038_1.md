# 38_1 - 트랜잭션 적용 전: 사진 게시판 추가하기
 
1) `수업 사진 게시판` 데이터를 다룰 DAO를 생성하라.
 
- tema.frr.chicken.domain.PhotoBoard 추가
  - 사진 게시물의 데이터 타입을 정의한다.
- tema.frr.chicken.dao.PhotoBoardDao 인터페이스 추가
  - 사진 게시물의 CRUD 관련 메서드 호출 규칙을 정의한다.
- tema.frr.chicken.dao.mariadb.PhotoBoardDaoImpl 추가
  - PhotoBoardDao 인터페이스를 구현한다.
- tema.frr.chicken.DataLoaderListener 변경
  - PhotoBoardDao 객체를 생성한다.
 
2) '/photoboard/list' 명령을 처리하라.
 
- tema.frr.chicken.servlet.PhotoBoardListServlet 추가
  - 사진 게시물의 목록을 출력한다.
- tema.frr.chicken.ServerApp 변경
  - `PhotoBoardListServlet` 객체를 생성하여 커맨드 맵에 보관한다.
  
3) '/photoboard/detail' 명령을 처리하라.
 
- tema.frr.chicken.domain.PhotoBoard 변경
  - 사진 후기 게시글 정보를 담을 ReviewBoard 타입의 인스턴스 필드를 추가한다.
- tema.frr.chicken.dao.mariadb.PhotoBoardDaoImpl 변경
  - findByClientNo(사진 후기 게시글 번호) 메서드 변경한다.
  - 사진 후기 게시글의 상세정보를 가져올 때 frr_photo와 frr_board을 조인한다.
  - frr_photo 데이터는 PhotoBoard에 저장하고, frr_board 데이터는 ReviewBoard에 저장한다.
- tema.frr.chicken.servlet.PhotoBoardDetailServlet 추가
  - 사진 게시물의 상세정보를 출력한다.
- tema.frr.chicken.ServerApp 변경
  - `PhotoBoardDetailServlet` 객체를 생성하여 커맨드 맵에 보관한다.
 
4) '/photoboard/add' 명령을 처리하라.
 
- tema.frr.chicken.servlet.PhotoBoardAddServlet 추가
  - 사진 게시물을 입력한다.
- tema.frr.chicken.ServerApp 변경
  - `PhotoBoardAddServlet` 객체를 생성하여 커맨드 맵에 보관한다.
 
 
5) '/photoboard/update' 명령을 처리하라.
 
- tema.frr.chicken.servlet.PhotoBoardUpdateServlet 추가
  - 사진 게시물을 변경한다.
- tema.frr.chicken.ServerApp 변경
  - `PhotoBoardUpdateServlet` 객체를 생성하여 커맨드 맵에 보관한다.
 
 
6) '/photoboard/delete' 명령을 처리하라.
 
- tema.frr.chicken.servlet.PhotoBoardDeleteServlet 추가
  - 사진 게시물을 삭제한다.
- tema.frr.chicken.ServerApp 변경
  - `PhotoBoardDeleteServlet` 객체를 생성하여 커맨드 맵에 보관한다.
 
 

# 38_4 - 트랜잭션 적용 후: 사진 게시글 입력과 첨부 파일 입력을 한 단위로 다루기
 
1) 트랜잭션을 사용하기 전의 문제점을 확인하라.
 
사진 게시물을 입력할 때,
첨부 파일 일부는 DB 컬럼에서 허용된 길이 보다 더 긴 값을 갖게 한다.
이 때 오류가 발생하는데, 그럼에도 불구하고 사진 게시글이 정상적으로 입력되고,
오류가 발생하기 전에 입력한 첨부파일이 정상적으로 입력 되는 것을 확인한다.
 
2) 사진 게시글 입력과 첨부파일 입력을 한 단위로 다뤄라.
 
사진 게시글과 첨부파일을 입력하는 코드를 트랜잭션으로 묶어 한 단위로 다룬다.
 
- tema.frr.chicken.servlet.PhotoBoardAddServlet 변경
  - 게시글 입력과 첨부파일 입력 부분을 실행하기 전에 수동 commit으로 설정한다.
  - 성공하면 commit(), 실패하면 rollback() 한다.
 
3) 사진 게시글 변경과 첨부파일 삭제, 입력을 한 단위로 다뤄라.
 
- tema.frr.chicken.servlet.PhotoBoardUpdateServlet 변경
  - 게시글 변경과 첨부파일 삭제,입력 부분을 실행하기 전에 수동 commit으로 설정한다.
  - 성공하면 commit(), 실패하면 rollback() 한다.
 
4) 사진 게시글 삭제와 첨부파일 삭제를 한 단위로 다뤄라.
 
- tema.frr.chicken.servlet.PhotoBoardDeleteServlet 변경
  - 게시글 삭제와 첨부파일 삭제를 실행하기 전에 수동 commit으로 설정한다.
  - 성공하면 commit(), 실패하면 rollback() 한다.
 

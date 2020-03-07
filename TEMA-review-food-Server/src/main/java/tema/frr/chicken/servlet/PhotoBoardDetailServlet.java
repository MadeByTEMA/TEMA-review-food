package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.Scanner;

import tema.frr.chicken.dao.PhotoBoardDao;
import tema.frr.chicken.domain.PhotoBoard;

public class PhotoBoardDetailServlet implements Servlet {

  PhotoBoardDao photoBoardDao;

  public PhotoBoardDetailServlet(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("사진 게시글 번호? ");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());

    PhotoBoard photoBoard = photoBoardDao.findByNo(no);

    if (photoBoard != null) {
      out.printf("번호: %d\n", photoBoard.getNo());
      out.printf("제목: %s\n", photoBoard.getTitle());
      out.printf("등록일: %s\n", photoBoard.getCreatedDate());
      out.printf("조회수: %d\n", photoBoard.getViewCount());
      out.printf("후기: %s\n", photoBoard.getReviewBoard().getReview());
    } else {
      out.println("해당 번호의 사진 게시글이 없습니다.");
    }
  }
}

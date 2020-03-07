package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import tema.frr.chicken.dao.PhotoBoardDao;
import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.PhotoBoard;
import tema.frr.chicken.domain.ReviewBoard;

public class PhotoBoardListServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  ReviewBoardDao reviewBoardDao;

  public PhotoBoardListServlet(PhotoBoardDao photoBoardDao, ReviewBoardDao reviewBoardDao) {
    this.photoBoardDao = photoBoardDao;
    this.reviewBoardDao = reviewBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("수업번호? ");
    out.println("!{}!");
    out.flush();

    int boardNo = Integer.parseInt(in.nextLine());

    ReviewBoard reviewBoard = reviewBoardDao.findByBoardNo(boardNo);

    if (reviewBoard == null) {
      out.println("후기 번호가 유효하지 않습니다.");
      return;
    }

    out.printf("후기: %s\n", reviewBoard.getReview());
    out.println("----------------------------------------------------------");

    List<PhotoBoard> photoBoards = photoBoardDao.findAllByBoardNo(boardNo);

    for (PhotoBoard photoBoard : photoBoards) {
      out.printf("%d, %s, %s, %d\n", //
          photoBoard.getNo(), //
          photoBoard.getTitle(), //
          photoBoard.getCreatedDate(), //
          photoBoard.getViewCount() //
          );
    }
  }
}

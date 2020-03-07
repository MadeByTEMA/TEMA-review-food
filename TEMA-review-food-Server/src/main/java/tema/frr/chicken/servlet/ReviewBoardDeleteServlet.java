package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.Scanner;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.util.Prompt;

public class ReviewBoardDeleteServlet implements Servlet {

  ReviewBoardDao reviewBoardDao;

  public ReviewBoardDeleteServlet(ReviewBoardDao reviewBoardDao) {
    this.reviewBoardDao = reviewBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int boardNo = Prompt.getInt(in, out, "번호? ");

    if (reviewBoardDao.delete(boardNo) > 0) {
      out.println("후기를 삭제했습니다.");

    } else {
      out.println("해당 후기가 없습니다.");
    }
  }
}

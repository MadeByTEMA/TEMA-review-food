package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.Scanner;

import tema.frr.chicken.dao.ReviewBoardDao;

public class ReviewBoardDeleteServlet implements Servlet {

  ReviewBoardDao reviewBoardDao;

  public ReviewBoardDeleteServlet(ReviewBoardDao reviewBoardDao) {
    this.reviewBoardDao = reviewBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int boardNo = Integer.parseInt(in.nextLine());

    if (reviewBoardDao.delete(boardNo) > 0) {
      out.println("후기를 삭제했습니다.");

    } else {
      out.println("해당 후기가 없습니다.");
    }
  }
}

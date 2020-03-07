package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.Scanner;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;
import tema.frr.util.Prompt;

public class ReviewBoardDetailServlet implements Servlet {

  ReviewBoardDao reviewBoardDao;

  public ReviewBoardDetailServlet(ReviewBoardDao reviewBoardDao) {
    this.reviewBoardDao = reviewBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int boardNo = Prompt.getInt(in, out, "번호? ");

    ReviewBoard reviewBoard = reviewBoardDao.findByBoardNo(boardNo);


    if (reviewBoard != null) {
      out.printf("메뉴 : %s\n", reviewBoard.getStoreName());
      out.printf("메뉴 : %s\n", reviewBoard.getMenu());
      out.printf("가격 : %s\n", reviewBoard.getPrice());
      out.printf("총 별점 : %s\n", reviewBoard.getStarTotalSum());
      out.printf("맛 별점:  %s\n", reviewBoard.getStarQuality());
      out.printf("양 별점 : %s\n", reviewBoard.getStarQuantity());
      out.printf("후기 : %s\n", reviewBoard.getReview());

    } else {
      out.println("해당 후기가 없습니다.");
    }
  }
}

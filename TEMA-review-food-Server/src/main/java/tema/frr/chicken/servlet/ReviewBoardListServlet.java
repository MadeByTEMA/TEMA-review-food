package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;

public class ReviewBoardListServlet implements Servlet {

  ReviewBoardDao reviewBoardDao;

  public ReviewBoardListServlet(ReviewBoardDao reviewBoardDao) {
    this.reviewBoardDao = reviewBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    try {
      List<ReviewBoard> reviewBoards = reviewBoardDao.findAll();

      for (ReviewBoard r : reviewBoards) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s\n",r.getBoardNo(), r.getStoreName(), r.getMenu(), r.getPrice(),
            r.getStarQuality(), r.getStarQuantity(), r.getStarTotalSum());
      }
    } catch (Exception e) {
      System.out.println("통신 오류 발생!");
    }
  }
}

package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.Scanner;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;

public class ReviewBoardUpdateServlet implements Servlet {

  ReviewBoardDao reviewBoardDao;

  public ReviewBoardUpdateServlet(ReviewBoardDao reviewBoardDao) {
    this.reviewBoardDao = reviewBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int boardNo = Integer.parseInt(in.nextLine());

    ReviewBoard oldReviewBoard = null;

    try {
      oldReviewBoard = reviewBoardDao.findByBoardNo(boardNo);
    } catch (Exception e) {
      System.out.println("해당 스토어의 게시글의 없습니다!");
      return;
    }

    ReviewBoard newReviewBoard = new ReviewBoard();

    newReviewBoard.setCategory(oldReviewBoard.getCategory());

    out.printf("가게명(%s) \n", oldReviewBoard.getStoreName());
    out.println("!{}!");
    out.flush();
    newReviewBoard.setStoreName(in.nextLine());

    out.printf("메뉴(%s) \n", oldReviewBoard.getMenu());
    out.println("!{}!");
    out.flush();
    newReviewBoard.setMenu(in.nextLine());

    out.printf("가격(%s) \n", oldReviewBoard.getPrice());
    out.println("!{}!");
    out.flush();
    newReviewBoard.setPrice(Integer.parseInt(in.nextLine()));

    out.printf("맛 별점(%s) \n", oldReviewBoard.getStarQuality());
    out.println("!{}!");
    out.flush();
    newReviewBoard.setStarQuality(Integer.parseInt(in.nextLine()));

    out.printf("양 별점(%s) \n", oldReviewBoard.getStarQuantity());
    out.println("!{}!");
    out.flush();
    newReviewBoard.setStarQuantity(Integer.parseInt(in.nextLine()));

    out.printf("후기(%s) \n", oldReviewBoard.getReview());
    out.println("!{}!");
    out.flush();
    newReviewBoard.setReview(in.nextLine());

    if (reviewBoardDao.update(oldReviewBoard) > 0) {
      out.println("후기를 변경했습니다.");
    } else {
      out.println("변경 실패!");
    }
  }
}

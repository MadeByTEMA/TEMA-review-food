package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.Scanner;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;
import tema.frr.util.Prompt;

public class ReviewBoardUpdateServlet implements Servlet {

  ReviewBoardDao reviewBoardDao;

  public ReviewBoardUpdateServlet(ReviewBoardDao reviewBoardDao) {
    this.reviewBoardDao = reviewBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int boardNo = Prompt.getInt(in, out, "번호? ");

    ReviewBoard oldReviewBoard = null;

    try {
      oldReviewBoard = reviewBoardDao.findByBoardNo(boardNo);
    } catch (Exception e) {
      System.out.println("해당 스토어의 게시글의 없습니다!");
      return;
    }

    ReviewBoard newReviewBoard = new ReviewBoard();

    newReviewBoard.setCategory(oldReviewBoard.getCategory());
    newReviewBoard.setStoreName(Prompt.getString(in, out,
        String.format("가게명(%s) \n", oldReviewBoard.getStoreName()), oldReviewBoard.getStoreName()));
    newReviewBoard.setMenu(Prompt.getString(in, out,
        String.format("메뉴(%s) \n", oldReviewBoard.getMenu()), oldReviewBoard.getMenu()));
    newReviewBoard.setPrice(Prompt.getInt(in, out,
        String.format("가격(%s) \n", oldReviewBoard.getPrice()), String.valueOf(oldReviewBoard.getPrice())));
    newReviewBoard.setStarQuality(Prompt.getInt(in, out,
        String.format("맛 별점(%s) \n", oldReviewBoard.getStarQuality()), String.valueOf(oldReviewBoard.getStarQuality())));
    newReviewBoard.setStarQuantity(Prompt.getInt(in, out,
        String.format("양 별점(%s) \n", oldReviewBoard.getStarQuantity()), String.valueOf(oldReviewBoard.getStarQuantity())));
    newReviewBoard.setReview(Prompt.getString(in, out,
        String.format("후기(%s) \n", oldReviewBoard.getReview()), oldReviewBoard.getReview()));

    if (reviewBoardDao.update(oldReviewBoard) > 0) {
      out.println("후기를 변경했습니다.");
    } else {
      out.println("변경 실패!");
    }
  }
}

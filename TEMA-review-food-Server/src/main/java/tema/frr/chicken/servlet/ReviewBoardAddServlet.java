package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.Scanner;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;

public class ReviewBoardAddServlet implements Servlet {

  ReviewBoardDao reviewBoardDao;

  public ReviewBoardAddServlet(ReviewBoardDao reviewBoardDao) {
    this.reviewBoardDao = reviewBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    ReviewBoard r = new ReviewBoard();

    out.println("가게명을 입력해주세요. ");
    out.println("!{}!");
    out.flush();
    r.setStoreName(in.nextLine());

    out.println("메뉴을 입력해주세요. ");
    out.println("!{}!");
    out.flush();
    r.setMenu(in.nextLine());

    out.println("가격을 입력해주세요. ");
    out.println("!{}!");
    out.flush();
    r.setPrice(Integer.parseInt(in.nextLine()));

    out.println("맛 별점을 입력해주세요. ");
    out.println("!{}!");
    out.flush();
    r.setStarQuality(Integer.parseInt(in.nextLine()));

    out.println("양 별점을 입력해주세요. ");
    out.println("!{}!");
    out.flush();
    r.setStarQuantity(Integer.parseInt(in.nextLine()));

    out.println("후기를 입력해주세요. ");
    out.println("!{}!");
    out.flush();
    r.setReview(in.nextLine());

    if (reviewBoardDao.update(r) > 0) {
      out.println("후기를 변경했습니다.");
    } else {
      out.println("변경 실패!");
    }
  }
}

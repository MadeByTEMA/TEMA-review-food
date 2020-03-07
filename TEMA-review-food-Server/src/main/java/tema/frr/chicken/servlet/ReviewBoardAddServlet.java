package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.Scanner;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;
import tema.frr.util.Prompt;

public class ReviewBoardAddServlet implements Servlet {

  ReviewBoardDao reviewBoardDao;

  public ReviewBoardAddServlet(ReviewBoardDao reviewBoardDao) {
    this.reviewBoardDao = reviewBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    ReviewBoard r = new ReviewBoard();

    r.setStoreName(Prompt.getString(in, out, "가게명을 입력해주세요. "));
    r.setMenu(Prompt.getString(in, out, "메뉴을 입력해주세요. "));
    r.setPrice(Prompt.getInt(in, out, "가격을 입력해주세요. "));
    r.setStarQuality(Prompt.getInt(in, out, "맛 별점을 입력해주세요. "));
    r.setStarQuantity(Prompt.getInt(in, out, "양 별점을 입력해주세요. "));
    r.setReview(Prompt.getString(in, out, "후기를 입력해주세요. "));

    if (reviewBoardDao.update(r) > 0) {
      out.println("후기를 변경했습니다.");
    } else {
      out.println("변경 실패!");
    }
  }
}

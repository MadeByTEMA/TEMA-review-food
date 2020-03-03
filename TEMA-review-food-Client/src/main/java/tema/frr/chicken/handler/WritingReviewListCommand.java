package tema.frr.chicken.handler;

import java.util.List;

import tema.frr.chicken.dao.proxy.ReviewBoardDaoProxy;
import tema.frr.chicken.domain.WritingReview;
import tema.frr.chicken.util.Prompt;

public class WritingReviewListCommand implements Command {

  ReviewBoardDaoProxy writingReviewDao;
  Prompt prompt;

  public WritingReviewListCommand(ReviewBoardDaoProxy writingReviewDao) {
    this.writingReviewDao = writingReviewDao;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {

    try {
      List<WritingReview> writingReviews = writingReviewDao.findAll();

      for (WritingReview r : writingReviews) {
        System.out.printf("%s, %s, %s, %s, %s, %s\n", r.getStoreName(), r.getMenu(), r.getPrice(),
            r.getStarQuality(), r.getStarQuantity(), r.getStarTotalSum());
      }
    } catch (Exception e) {
      System.out.println("통신 오류 발생!");
    }
  }
}

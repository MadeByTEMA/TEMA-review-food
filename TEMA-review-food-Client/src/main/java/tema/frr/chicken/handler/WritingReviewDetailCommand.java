package tema.frr.chicken.handler;

import tema.frr.chicken.dao.proxy.WritingReviewDaoProxy;
import tema.frr.chicken.domain.WritingReview;
import tema.frr.chicken.util.Prompt;

public class WritingReviewDetailCommand implements Command {

  WritingReviewDaoProxy writingReviewDao;
  Prompt prompt;

  public WritingReviewDetailCommand(WritingReviewDaoProxy writingReviewDao, Prompt prompt) {
    this.writingReviewDao = writingReviewDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      String storeName =(prompt.inputString("스토어명? "));
      WritingReview writingReview = writingReviewDao.findByStoreName(storeName);

      System.out.printf("메뉴 : %s\n", writingReview.getMenu());
      System.out.printf("가격 : %s\n", writingReview.getPrice());
      System.out.printf("총 별점 : %s\n", writingReview.getStarTotalSum());
      System.out.printf("맛 별점:  %s\n", writingReview.getStarQuality());
      System.out.printf("양 별점 : %s\n", writingReview.getStarQuantity());
      System.out.printf("후기 : %s\n", writingReview.getReview());
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}

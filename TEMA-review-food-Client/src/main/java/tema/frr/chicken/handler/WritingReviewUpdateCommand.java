package tema.frr.chicken.handler;

import tema.frr.chicken.dao.proxy.WritingReviewDaoProxy;
import tema.frr.chicken.domain.WritingReview;
import tema.frr.chicken.util.Prompt;

public class WritingReviewUpdateCommand implements Command {

  WritingReviewDaoProxy writingReviewDao;
  Prompt prompt;

  public WritingReviewUpdateCommand(WritingReviewDaoProxy writingReviewDao, Prompt prompt) {
    this.writingReviewDao = writingReviewDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      String storeName =(prompt.inputString("스토어명? "));

      WritingReview oldWritingReview = null;
      try {
        oldWritingReview = writingReviewDao.findByStoreName(storeName);
      } catch (Exception e) {
        System.out.println("해당 스토어의 게시글의 없습니다!");
        return;
      }

      WritingReview newWritingReview = new WritingReview();

      newWritingReview.setCategory(oldWritingReview.getCategory());
      newWritingReview.setStoreName(oldWritingReview.getStoreName());

      newWritingReview.setMenu(prompt.inputString(
          String.format("메뉴(%s) \n", oldWritingReview.getMenu()), oldWritingReview.getMenu()));

      newWritingReview.setPrice(prompt.inputInt(
          String.format("가격(%s) \n", oldWritingReview.getPrice()), oldWritingReview.getPrice()));

      newWritingReview.setStarQuality(
          prompt.inputInt(String.format("맛 별점(%s) \n", oldWritingReview.getStarQuality()),
              oldWritingReview.getStarQuality()));

      newWritingReview.setStarQuantity(
          prompt.inputInt(String.format("양 별점(%s) \n", oldWritingReview.getStarQuantity()),
              oldWritingReview.getStarQuantity()));

      newWritingReview.setReview(prompt.inputString(
          String.format("후기(%s) \n", oldWritingReview.getReview()), oldWritingReview.getReview()));

      if (newWritingReview.equals(oldWritingReview)) {
        System.out.println(" 후기 변경을 취소하였습니다.");
        return;
      }

      writingReviewDao.update(newWritingReview);
      System.out.println("후기를 변경했습니다.");

    } catch (Exception e) {
      System.out.println("변경 실패!");
    }
  }
}

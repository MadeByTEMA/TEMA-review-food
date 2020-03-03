package tema.frr.chicken.handler;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;
import tema.frr.chicken.util.Prompt;

public class ReviewBoardUpdateCommand implements Command {

  ReviewBoardDao reviewBoardDao;
  Prompt prompt;

  public ReviewBoardUpdateCommand(ReviewBoardDao reviewBoardDao, Prompt prompt) {
    this.reviewBoardDao = reviewBoardDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int boardNo =(prompt.inputInt("번호? "));

      ReviewBoard oldReviewBoard = null;
      try {
        oldReviewBoard = reviewBoardDao.findByBoardNo(boardNo);
      } catch (Exception e) {
        System.out.println("해당 스토어의 게시글의 없습니다!");
        return;
      }

      ReviewBoard newReviewBoard = new ReviewBoard();

      newReviewBoard.setCategory(oldReviewBoard.getCategory());
      newReviewBoard.setStoreName(prompt.inputString(
          String.format("가게명(%s) \n", oldReviewBoard.getStoreName()), oldReviewBoard.getStoreName()));

      newReviewBoard.setMenu(prompt.inputString(
          String.format("메뉴(%s) \n", oldReviewBoard.getMenu()), oldReviewBoard.getMenu()));

      newReviewBoard.setPrice(prompt.inputInt(
          String.format("가격(%s) \n", oldReviewBoard.getPrice()), oldReviewBoard.getPrice()));

      newReviewBoard.setStarQuality(
          prompt.inputInt(String.format("맛 별점(%s) \n", oldReviewBoard.getStarQuality()),
              oldReviewBoard.getStarQuality()));

      newReviewBoard.setStarQuantity(
          prompt.inputInt(String.format("양 별점(%s) \n", oldReviewBoard.getStarQuantity()),
              oldReviewBoard.getStarQuantity()));

      newReviewBoard.setReview(prompt.inputString(
          String.format("후기(%s) \n", oldReviewBoard.getReview()), oldReviewBoard.getReview()));

      if (newReviewBoard.equals(oldReviewBoard)) {
        System.out.println(" 후기 변경을 취소하였습니다.");
        return;
      }

      reviewBoardDao.update(newReviewBoard);
      System.out.println("후기를 변경했습니다.");

    } catch (Exception e) {
      System.out.println("변경 실패!");
    }
  }
}

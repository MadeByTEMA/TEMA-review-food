package tema.frr.chicken.handler;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;
import tema.frr.chicken.util.Prompt;

public class ReviewBoardAddCommand implements Command {

  ReviewBoardDao reviewBoardDao;
  Prompt prompt;

  public ReviewBoardAddCommand(ReviewBoardDao reviewBoardwDao, Prompt prompt) {
    this.reviewBoardDao = reviewBoardwDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    ReviewBoard r = new ReviewBoard();

    r.setStoreName(prompt.inputString("가게명을 입력해주세요. "));
    r.setMenu(prompt.inputString("메뉴을 입력해주세요. "));
    r.setPrice(prompt.inputInt("가격을 입력해주세요. "));
    r.setStarQuality(prompt.inputInt("맛 별점을 입력해주세요. "));
    r.setStarQuantity(prompt.inputInt("양 별점을 입력해주세요. "));
    r.setReview(prompt.inputString("후기를 입력해주세요. "));

    try {
      reviewBoardDao.insert(r);
      System.out.println("저장하였습니다.");

    } catch (Exception e) {
      System.out.println("저장 실패!");
    }
  }
}

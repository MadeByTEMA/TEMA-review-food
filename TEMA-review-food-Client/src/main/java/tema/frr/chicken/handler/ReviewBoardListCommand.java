package tema.frr.chicken.handler;

import java.util.List;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;
import tema.frr.chicken.util.Prompt;

public class ReviewBoardListCommand implements Command {

  ReviewBoardDao reviewBoardDao;
  Prompt prompt;

  public ReviewBoardListCommand(ReviewBoardDao reviewBoardwDao) {
    this.reviewBoardDao = reviewBoardwDao;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {

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

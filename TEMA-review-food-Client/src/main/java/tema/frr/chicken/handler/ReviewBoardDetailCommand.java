package tema.frr.chicken.handler;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;
import tema.frr.chicken.util.Prompt;

public class ReviewBoardDetailCommand implements Command {

  ReviewBoardDao reviewBoardDao;
  Prompt prompt;

  public ReviewBoardDetailCommand(ReviewBoardDao reviewBoardDao, Prompt prompt) {
    this.reviewBoardDao = reviewBoardDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int boardNo =(prompt.inputInt("번호? "));
      ReviewBoard reviewBoard = reviewBoardDao.findByBoardNo(boardNo);

      System.out.printf("메뉴 : %s\n", reviewBoard.getStoreName());
      System.out.printf("메뉴 : %s\n", reviewBoard.getMenu());
      System.out.printf("가격 : %s\n", reviewBoard.getPrice());
      System.out.printf("총 별점 : %s\n", reviewBoard.getStarTotalSum());
      System.out.printf("맛 별점:  %s\n", reviewBoard.getStarQuality());
      System.out.printf("양 별점 : %s\n", reviewBoard.getStarQuantity());
      System.out.printf("후기 : %s\n", reviewBoard.getReview());
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}

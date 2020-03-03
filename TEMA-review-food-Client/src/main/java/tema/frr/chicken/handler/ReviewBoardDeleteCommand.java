package tema.frr.chicken.handler;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.util.Prompt;

public class ReviewBoardDeleteCommand implements Command {

  ReviewBoardDao reviewBoardDao;
  Prompt prompt;

  public ReviewBoardDeleteCommand(ReviewBoardDao reviewBoardDao, Prompt prompt) {
    this.reviewBoardDao = reviewBoardDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int boardNo =(prompt.inputInt("번호? "));
      reviewBoardDao.delete(boardNo);
      System.out.println("후기 정보를 삭제했습니다.");

    } catch (Exception e) {
      System.out.println("삭제 실패!");
    }
  }
}

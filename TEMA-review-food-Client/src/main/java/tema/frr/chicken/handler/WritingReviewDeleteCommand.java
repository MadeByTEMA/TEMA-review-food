package tema.frr.chicken.handler;

import tema.frr.chicken.dao.proxy.WritingReviewDaoProxy;
import tema.frr.chicken.util.Prompt;

public class WritingReviewDeleteCommand implements Command {

  WritingReviewDaoProxy writingReviewDao;
  Prompt prompt;

  public WritingReviewDeleteCommand(WritingReviewDaoProxy writingReviewDao, Prompt prompt) {
    this.writingReviewDao = writingReviewDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      String storeName =(prompt.inputString("스토어명? "));
      writingReviewDao.delete(storeName);
      System.out.println("후기 정보를 삭제했습니다.");

    } catch (Exception e) {
      System.out.println("삭제 실패!");
    }
  }
}

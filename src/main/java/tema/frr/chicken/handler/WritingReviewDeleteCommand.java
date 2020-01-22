package tema.frr.chicken.handler;

import java.util.List;
import tema.frr.chicken.domain.WritingReview;
import tema.frr.util.Prompt;

public class WritingReviewDeleteCommand implements Command {

  List<WritingReview> writingReviewList;

  Prompt prompt;

  public WritingReviewDeleteCommand(Prompt prompt, List<WritingReview> list) {
    this.prompt = prompt;
    writingReviewList = list;
  }

  @Override
  public void execute() {
    int index = indexOfWritingReview(prompt.inputString("가게명? "));

    if (index == -1) {
      System.out.println("해당 후기를 찾을 수 없습니다.");
      return;
    } else {
      this.writingReviewList.remove(index);
      System.out.println("후기를 삭제했습니다.");
    }
  }

  private int indexOfWritingReview(String storeName) {
    for (int i = 0; i < this.writingReviewList.size(); i++) {
      WritingReview temp = this.writingReviewList.get(i);
      if (storeName.equals(temp.getStoreName())) {
        return i;
      }
    }
    return -1;
  }
}

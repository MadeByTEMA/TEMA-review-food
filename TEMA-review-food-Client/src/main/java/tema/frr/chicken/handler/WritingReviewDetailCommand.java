package tema.frr.chicken.handler;

import java.util.List;
import tema.frr.chicken.domain.WritingReview;
import tema.frr.util.Prompt;

public class WritingReviewDetailCommand implements Command {

  List<WritingReview> writingReviewList;

  Prompt prompt;

  public WritingReviewDetailCommand(Prompt prompt, List<WritingReview> list) {
    this.prompt = prompt;
    writingReviewList = list;
  }

  @Override
  public void execute() {

    int index = indexOfWritingReview(prompt.inputString("가게명? "));

    if (index == -1) {
      System.out.println("해당 고객을 찾을 수 없습니다.");
      return;
    }

    WritingReview writingReview = this.writingReviewList.get(index);

    System.out.printf("메뉴 : %s\n", writingReview.getMenu());
    System.out.printf("가격 : %s\n", writingReview.getPrice());
    System.out.printf("총 별점 : %s\n", writingReview.getStarTotalSum());
    System.out.printf("맛 별점:  %s\n", writingReview.getStarQuality());
    System.out.printf("양 별점 : %s\n", writingReview.getStarQuantity());
    System.out.printf("후기 : %s\n", writingReview.getReview());
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

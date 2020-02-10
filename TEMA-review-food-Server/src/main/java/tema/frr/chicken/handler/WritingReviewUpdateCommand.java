package tema.frr.chicken.handler;

import java.util.List;
import tema.frr.chicken.domain.WritingReview;
import tema.frr.util.Prompt;

public class WritingReviewUpdateCommand implements Command {

  List<WritingReview> writingReviewList;

  Prompt prompt;

  public WritingReviewUpdateCommand(Prompt prompt, List<WritingReview> list) {
    this.prompt = prompt;
    writingReviewList = list;
  }

  @Override
  public void execute() {

    int index = indexOfWritingReview(prompt.inputString("가게명? "));

    if (index == -1) {
      System.out.println("해당 후기를 찾을 수 없습니다.");
      return;
    }

    WritingReview oldWritingReview = this.writingReviewList.get(index);
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
    } else {
      this.writingReviewList.set(index, newWritingReview);
      System.out.println("후기를 변경하였습니다.");
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

package tema.frr.chicken.handler;

import java.util.List;
import tema.frr.chicken.domain.WritingReview;
import tema.frr.util.Prompt;

public class WritingReviewAddCommand implements Command {

  List<WritingReview> writingReviewList;

  Prompt prompt;

  public WritingReviewAddCommand(Prompt prompt, List<WritingReview> list) {
    this.prompt = prompt;
    writingReviewList = list;
  }

  @Override
  public void execute() {
    WritingReview r = new WritingReview();

    r.setStoreName(prompt.inputString("가게명을 입력해주세요. "));
    r.setMenu(prompt.inputString("메뉴을 입력해주세요. "));
    r.setPrice(prompt.inputInt("가격을 입력해주세요. "));
    r.setStarQuality(prompt.inputInt("맛 별점을 입력해주세요. "));
    r.setStarQuantity(prompt.inputInt("양 별점을 입력해주세요. "));
    r.setReview(prompt.inputString("후기를 입력해주세요. "));

    writingReviewList.add(r);

    System.out.println("저장하였습니다.");
  }
}

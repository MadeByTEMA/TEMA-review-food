package tema.frr.chicken.handler;

import java.util.Iterator;
import java.util.List;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewListCommand implements Command {

  List<WritingReview> writingReviewList;

  public WritingReviewListCommand(List<WritingReview> list) {
    writingReviewList = list;
  }

  @Override
  public void execute() {
    Iterator<WritingReview> iterator = writingReviewList.iterator();

    while (iterator.hasNext()) {
      WritingReview r = iterator.next();
      System.out.printf("%s, %s, %s, %s, %s, %s\n", r.getStoreName(), r.getMenu(), r.getPrice(),
          r.getStarQuality(), r.getStarQuantity(), r.getStarTotalSum());
    }
  }
}

package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewUpdateServlet implements Servlet {

  List<WritingReview> writingReviews;

  public WritingReviewUpdateServlet(List<WritingReview> writingReviews) {
    this.writingReviews = writingReviews;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    try {
      WritingReview writingReview = (WritingReview) in.readObject();

      int index = -1;
      for (int i = 0; i < writingReviews.size(); i++) {
        if (writingReviews.get(i).getStoreName() == writingReview.getStoreName()) {
          index = i;
          break;
        }
      }

      if (index != -1) {
        writingReviews.set(index, writingReview);
        out.writeUTF("OK");
      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 후기가 없습니다.");
      }

    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }
}

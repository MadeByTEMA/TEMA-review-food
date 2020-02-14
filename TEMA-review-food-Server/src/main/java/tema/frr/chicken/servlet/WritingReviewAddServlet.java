package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewAddServlet implements Servlet {

  List<WritingReview> writingReviews;

  public WritingReviewAddServlet(List<WritingReview> writingReviews) {
    this.writingReviews = writingReviews;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    try {
      WritingReview writingReview = (WritingReview) in.readObject();

      int i = 0;
      for (; i < writingReviews.size(); i++) {
        if (writingReviews.get(i).getStoreName() == writingReview.getStoreName()) {
          break;
        }
      }

      if (i == writingReviews.size()) { // 같은 번호의 게시물이 없다면,
        writingReviews.add(writingReview); // 새 게시물을 등록한다.
        out.writeUTF("OK");

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("같은 ID의 고객이 있습니다.");
      }

    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }
}

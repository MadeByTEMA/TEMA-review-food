package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewDetailServlet implements Servlet {

  List<WritingReview> writingReviews;

  public WritingReviewDetailServlet(List<WritingReview> writingReviews) {
    this.writingReviews = writingReviews;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    try {
      String storeName = in.readUTF();

      WritingReview writingReview = null;
      for (WritingReview b : writingReviews) {
        if (b.getStoreName() == storeName) {
          writingReview = b;
          break;
        }
      }

      if (writingReview != null) {
        out.writeUTF("OK");
        out.writeObject(writingReview);

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

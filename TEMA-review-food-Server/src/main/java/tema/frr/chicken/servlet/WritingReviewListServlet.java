package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewListServlet implements Servlet {

  List<WritingReview> writingReviews;

  public WritingReviewListServlet(List<WritingReview> writingReviews) {
    this.writingReviews = writingReviews;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(writingReviews);
  }
}

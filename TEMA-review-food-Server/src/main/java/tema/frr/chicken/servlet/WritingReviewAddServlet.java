package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tema.frr.chicken.dao.WritingReviewDao;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewAddServlet implements Servlet {

  WritingReviewDao writingReviewDao;

  public WritingReviewAddServlet(WritingReviewDao writingReviewDao) {
    this.writingReviewDao = writingReviewDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    WritingReview writingReview = (WritingReview) in.readObject();

    if (writingReviewDao.insert(writingReview) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("같은 ID의 고객이 있습니다.");
    }
  }
}

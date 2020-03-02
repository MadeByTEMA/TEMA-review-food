package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tema.frr.chicken.dao.WritingReviewDao;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewUpdateServlet implements Servlet {

  WritingReviewDao writingReviewDao;

  public WritingReviewUpdateServlet(WritingReviewDao writingReviewDao) {
    this.writingReviewDao = writingReviewDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    WritingReview writingReview = (WritingReview) in.readObject();

    if (writingReviewDao.update(writingReview) > 0) {
      out.writeUTF("OK");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 후기가 없습니다.");
    }
  }
}

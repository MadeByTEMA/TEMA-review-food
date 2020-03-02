package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tema.frr.chicken.dao.WritingReviewDao;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewDetailServlet implements Servlet {

  WritingReviewDao writingReviewDao;

  public WritingReviewDetailServlet(WritingReviewDao writingReviewDao) {
    this.writingReviewDao = writingReviewDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    String storeName = in.readUTF();

    WritingReview writingReview = writingReviewDao.findByStoreName(storeName);


    if (writingReview != null) {
      out.writeUTF("OK");
      out.writeObject(writingReview);

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 후기가 없습니다.");
    }
  }
}

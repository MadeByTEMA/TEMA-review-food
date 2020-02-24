package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.dao.json.WritingReviewJsonFileDao;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewDetailServlet implements Servlet {

  WritingReviewJsonFileDao writingReviewJsonFileDao;

  public WritingReviewDetailServlet(WritingReviewJsonFileDao writingReviewJsonFileDao) {
    this.writingReviewJsonFileDao = writingReviewJsonFileDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    String storeName = in.readUTF();

    WritingReview writingReview = writingReviewJsonFileDao.findByStoreName(storeName);


    if (writingReview != null) {
      out.writeUTF("OK");
      out.writeObject(writingReview);

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 후기가 없습니다.");
    }
  }
}

package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.dao.json.WritingReviewJsonFileDao;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewUpdateServlet implements Servlet {

  WritingReviewJsonFileDao writingReviewJsonFileDao;

  public WritingReviewUpdateServlet(WritingReviewJsonFileDao writingReviewJsonFileDao) {
    this.writingReviewJsonFileDao = writingReviewJsonFileDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    WritingReview writingReview = (WritingReview) in.readObject();

    if (writingReviewJsonFileDao.update(writingReview) > 0) {
      out.writeUTF("OK");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 후기가 없습니다.");
    }
  }
}

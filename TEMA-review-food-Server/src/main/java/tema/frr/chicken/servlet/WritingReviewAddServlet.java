package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.dao.json.WritingReviewJsonFileDao;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewAddServlet implements Servlet {

  WritingReviewJsonFileDao writingReviewJsonFileDao;

  public WritingReviewAddServlet(WritingReviewJsonFileDao writingReviewJsonFileDao) {
    this.writingReviewJsonFileDao = writingReviewJsonFileDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    WritingReview writingReview = (WritingReview) in.readObject();

    if (writingReviewJsonFileDao.insert(writingReview) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("같은 ID의 고객이 있습니다.");
    }
  }
}

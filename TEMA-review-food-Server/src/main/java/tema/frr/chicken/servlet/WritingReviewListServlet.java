package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.dao.json.WritingReviewJsonFileDao;

public class WritingReviewListServlet implements Servlet {

  WritingReviewJsonFileDao writingReviewJsonFileDao;

  public WritingReviewListServlet(WritingReviewJsonFileDao writingReviewJsonFileDao) {
    this.writingReviewJsonFileDao = writingReviewJsonFileDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(writingReviewJsonFileDao.findAll());
  }
}

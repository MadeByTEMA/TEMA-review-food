package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.dao.json.WritingReviewJsonFileDao;

public class WritingReviewDeleteServlet implements Servlet {

  WritingReviewJsonFileDao writingReviewJsonFileDao;

  public WritingReviewDeleteServlet(WritingReviewJsonFileDao writingReviewJsonFileDao) {
    this.writingReviewJsonFileDao = writingReviewJsonFileDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    String storeName = in.readUTF();

    if (writingReviewJsonFileDao.delete(storeName) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 후기가 없습니다.");
    }
  }
}

package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tema.frr.chicken.dao.WritingReviewDao;

public class WritingReviewDeleteServlet implements Servlet {

  WritingReviewDao writingReviewDao;

  public WritingReviewDeleteServlet(WritingReviewDao writingReviewDao) {
    this.writingReviewDao = writingReviewDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    String storeName = in.readUTF();

    if (writingReviewDao.delete(storeName) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 후기가 없습니다.");
    }
  }
}

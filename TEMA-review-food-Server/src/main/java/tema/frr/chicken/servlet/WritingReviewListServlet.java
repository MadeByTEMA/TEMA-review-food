package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tema.frr.chicken.dao.WritingReviewDao;

public class WritingReviewListServlet implements Servlet {

  WritingReviewDao writingReviewDao;

  public WritingReviewListServlet(WritingReviewDao writingReviewDao) {
    this.writingReviewDao = writingReviewDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(writingReviewDao.findAll());
  }
}

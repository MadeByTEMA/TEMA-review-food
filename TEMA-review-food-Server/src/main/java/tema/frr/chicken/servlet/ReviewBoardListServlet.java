package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tema.frr.chicken.dao.ReviewBoardDao;

public class ReviewBoardListServlet implements Servlet {

  ReviewBoardDao ReviewBoardDao;

  public ReviewBoardListServlet(ReviewBoardDao ReviewBoardDao) {
    this.ReviewBoardDao = ReviewBoardDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(ReviewBoardDao.findAll());
  }
}

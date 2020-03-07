package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;

public class ReviewBoardUpdateServlet implements Servlet {

  ReviewBoardDao reviewBoardDao;

  public ReviewBoardUpdateServlet(ReviewBoardDao reviewBoardDao) {
    this.reviewBoardDao = reviewBoardDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    ReviewBoard ReviewBoard = (ReviewBoard) in.readObject();

    if (reviewBoardDao.update(ReviewBoard) > 0) {
      out.writeUTF("OK");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 후기가 없습니다.");
    }
  }
}

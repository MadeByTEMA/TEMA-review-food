package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;

public class ReviewBoardAddServlet implements Servlet {

  ReviewBoardDao reviewBoardwDao;

  public ReviewBoardAddServlet(ReviewBoardDao ReviewBoardDao) {
    this.reviewBoardwDao = ReviewBoardDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    ReviewBoard ReviewBoard = (ReviewBoard) in.readObject();

    if (reviewBoardwDao.insert(ReviewBoard) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("같은 ID의 고객이 있습니다.");
    }
  }
}

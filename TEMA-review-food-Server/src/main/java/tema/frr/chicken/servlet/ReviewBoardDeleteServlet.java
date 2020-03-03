package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tema.frr.chicken.dao.ReviewBoardDao;

public class ReviewBoardDeleteServlet implements Servlet {

  ReviewBoardDao reviewBoardDao;

  public ReviewBoardDeleteServlet(ReviewBoardDao reviewBoardDao) {
    this.reviewBoardDao = reviewBoardDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int boardNo = in.readInt();

    if (reviewBoardDao.delete(boardNo) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 후기가 없습니다.");
    }
  }
}

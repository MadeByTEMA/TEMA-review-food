package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;

public class ReviewBoardDetailServlet implements Servlet {

  ReviewBoardDao ReviewBoardDao;

  public ReviewBoardDetailServlet(ReviewBoardDao ReviewBoardDao) {
    this.ReviewBoardDao = ReviewBoardDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int boardNo = in.readInt();

    ReviewBoard ReviewBoard = ReviewBoardDao.findByBoardNo(boardNo);


    if (ReviewBoard != null) {
      out.writeUTF("OK");
      out.writeObject(ReviewBoard);

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 후기가 없습니다.");
    }
  }
}

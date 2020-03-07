package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.Scanner;

import tema.frr.chicken.dao.PhotoBoardDao;
import tema.frr.chicken.domain.PhotoBoard;
import tema.frr.chicken.domain.ReviewBoard;

public class PhotoBoardAddServlet implements Servlet {

  PhotoBoardDao photoBoardDao;

  public PhotoBoardAddServlet(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    PhotoBoard photoBoard = new PhotoBoard();

    out.println("제목? ");
    out.println("!{}!");
    out.flush();
    photoBoard.setTitle(in.nextLine());

    out.println("수업 번호? ");
    out.println("!{}!");
    out.flush();

    ReviewBoard reviewBoard = new ReviewBoard();
    reviewBoard.setBoardNo(Integer.parseInt(in.nextLine()));

    photoBoard.setReviewBoard(reviewBoard);

    if (photoBoardDao.insert(photoBoard) > 0) {
      out.println("새 사진 게시글을 등록했습니다.");

    } else {
      out.println("사진 게시글 등록에 실패했습니다.");
    }
  }
}

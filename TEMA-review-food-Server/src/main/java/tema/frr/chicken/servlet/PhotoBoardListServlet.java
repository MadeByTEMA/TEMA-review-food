package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import tema.frr.chicken.dao.PhotoBoardDao;
import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.PhotoBoard;
import tema.frr.chicken.domain.ReviewBoard;

public class PhotoBoardListServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  ReviewBoardDao reviewBoardDao;

  public PhotoBoardListServlet(PhotoBoardDao photoBoardDao, ReviewBoardDao reviewBoardDao) {
    this.photoBoardDao = photoBoardDao;
    this.reviewBoardDao = reviewBoardDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("수업번호? ");
    out.println("!{}!");
    out.flush();

    int boardNo = Integer.parseInt(in.nextLine());

    // 1) 수업 번호로 수업 정보를 가져온다.
    ReviewBoard reviewBoard = reviewBoardDao.findByBoardNo(boardNo);

    // 2) 수업 번호에 해당하는 수업을 못찾았다면,
    // 안내 문구를 출력하고 응답을 종료한다.
    if (reviewBoard == null) {
      out.println("후기 번호가 유효하지 않습니다.");
      return;
    }

    // 3) 수업 번호에 해당하는 수업을 찾았다면, 수업명을 출력한다.
    out.printf("후기: %s\n", reviewBoard.getReview());
    out.println("----------------------------------------------------------");

    // 4) 해당 수업의 사진 게시글을 가져온다.
    List<PhotoBoard> photoBoards = photoBoardDao.findAllByBoardNo(boardNo);

    // 5) 클라이언트에게 게시글을 출력한다.
    for (PhotoBoard photoBoard : photoBoards) {
      out.printf("%d, %s, %s, %d\n", //
          photoBoard.getNo(), //
          photoBoard.getTitle(), //
          photoBoard.getCreatedDate(), //
          photoBoard.getViewCount() //
          );
    }
  }
}
